package manual_tests

import com.crypterium.cryptApi.Auth.service
import com.crypterium.cryptApi.AuthProvider
import com.crypterium.cryptApi.pojos.catalogs.CatalogCurrency
import com.crypterium.cryptApi.pojos.customerprofile.ProfileReq
import com.crypterium.cryptApi.pojos.wallets.WalletListResp
import com.crypterium.cryptApi.utils.BalanceAssertManager
import com.crypterium.cryptApi.utils.EndPoints
import com.crypterium.cryptApi.utils.SpecStorage
import io.restassured.response.ResponseBodyExtractionOptions
import org.junit.Assert
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigDecimal
import java.math.RoundingMode

class FiatWalletChecks {

    companion object {

        inline fun <reified T> ResponseBodyExtractionOptions.to(): T {
            return this.`as`(T::class.java)
        }


        @JvmStatic
        fun currencyProvider() : Collection<String> {
            val currencies =  SpecStorage.exwal().get(EndPoints.catalog_currencies).to<Array<CatalogCurrency>>()
            return currencies.map { it.code }
        }
    }


    @ParameterizedTest
    @MethodSource("currencyProvider")
    fun testFiatWallet(currency: String) {
        service<AuthProvider>().auth().body(ProfileReq().setPrimaryCurrency(currency)).put(EndPoints.customer_profile)

        val scale = 6
        val resp = service<AuthProvider>().auth().get(EndPoints.wallet_list).to<WalletListResp>()
        val wallets = resp.wallets


        var isFailed = false
        val fiatValues = mutableListOf<BigDecimal>()
        val changeValues = mutableListOf<BigDecimal>()

        wallets.filter {
            it.fiat.rate > BigDecimal.ZERO
        }.forEach {
            println("WALLET: ${it.currency}")
            println()
            val fiatAmount = it.fiat.amount
            val balance = it.balance
            val rate = it.fiat.rate
            val changePercent = it.fiat.changePercent
            val change = it.fiat.change

            val calculated = fiatAmount.divide(balance.multiply(rate), 20, RoundingMode.HALF_UP)
            val delta = BigDecimal("0.01").divide(rate, 20, RoundingMode.HALF_UP)
            println(" Check 1. wallet.fiat.amount / (wallet.balance * wallet.fiat.rate) ~= 1 +- delta")
            println("  ${fiatAmount.toPlainString()} / ${balance.toPlainString()} * ${rate.toPlainString()} ~= 1 +- ${delta.toPlainString()}")
            val low = BigDecimal.ONE.minus(delta)
            var up = BigDecimal.ONE.plus(delta)
            if (calculated >= low && calculated <= up) {
                println("   - OK.")
            } else {
                println("   - FAILED. ${calculated.toPlainString()} not in range [${low.toPlainString()}, ${up.toPlainString()}]")
                isFailed = true
            }
            println()
            println(" Check 2. wallet.fiat[amount * changePercent / change] ~= 100%.")
            println("  ${fiatAmount.toPlainString()} * ${changePercent.toPlainString()} / ${change.toPlainString()} ~= 100%")
            val expectedPercent = fiatAmount.multiply(changePercent).divide(change, 2, RoundingMode.HALF_UP)
            if (expectedPercent.toDouble() in 99..101) {
                println("   - OK.")
            } else {
                println("   - FAILED. ${expectedPercent.toPlainString()} not in range [99..101]")
                isFailed = true
            }
            println()
            fiatValues.add(it.fiat.amount)
            changeValues.add(it.fiat.change)
            println()
        }
        println("FINAL CHECKS")
        val fiatAmount = resp.fiat.amount
        val fiatChange = resp.fiat.change
        val percent = resp.fiat.changePercent

        println(" Check 1. fiat.amount = sum(wallet.fiat.amount)")
        println("  ${fiatAmount.toPlainString()} = ${fiatValues.joinToString(separator = " + ")}")
        val expected = fiatValues.reduce(BigDecimal::add)
        if (BalanceAssertManager.equal(fiatAmount, expected, 6)) {
            println("  - OK.")
        } else {
            println("  - FAILED. $fiatAmount <> $expected (scale = $scale)")
            isFailed = true
        }

        println()
        println(" Check 2. fiat.change = sum(wallet.fiat.change)")
        println("  ${fiatChange.toPlainString()} = ${changeValues.joinToString(separator = " + ")}")
        val expectedChange = changeValues.reduce(BigDecimal::add)
        if (BalanceAssertManager.equal(fiatChange, expectedChange, 6)) {
            println("  - OK.")
        } else {
            println("  - FAILED. $fiatChange <> $expectedChange (scale = $scale)")
            isFailed = true
        }

        println()
        println(" Check 3. wallet.fiat[amount * changePercent / change] ~= 100%.")
        println("  ${fiatAmount.toPlainString()} * ${percent.toPlainString()} / ${fiatChange.toPlainString()} ~= 100%")
        val expectedPercent = fiatAmount.multiply(percent).divide(fiatChange, 2, RoundingMode.HALF_UP)
        if (expectedPercent.toDouble() in 99..101) {
            println("  - OK.")
        } else {
            println("  - FAILED. $expectedPercent not in range [99..101]")
            isFailed = true
        }

        Assert.assertFalse(isFailed)
    }
}