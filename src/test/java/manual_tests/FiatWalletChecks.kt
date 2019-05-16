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

        wallets.forEach {
            println("WALLET: ${it.currency}")
            println()
            val fiatAmount = it.fiat.amount
            val balance = it.balance
            val rate = it.fiat.rate
            val changePercent = it.fiat.changePercent
            val change = it.fiat.change

            val expected = it.balance.multiply(it.fiat.rate)
            println(" Check 1. wallet.fiat.amount = wallet.balance * wallet.fiat.rate.")
            println("  $fiatAmount = $balance * $rate")
            if (BalanceAssertManager.equal(it.fiat.amount, expected, scale)) {
                println("   - OK.")
            } else {
                println("   - FAILED. $fiatAmount <> $expected (scale = $scale)")
                isFailed = true
            }
            println()
            println(" Check 2. wallet.fiat[amount * changePercent / change] ~= 100%.")
            println("  $fiatAmount * $changePercent / $change ~= 100%")
            val expectedPercent = fiatAmount.multiply(changePercent).divide(change, 2, RoundingMode.HALF_UP)
            if (expectedPercent.toDouble() in 99..101) {
                println("   - OK.")
            } else {
                println("   - FAILED. $expectedPercent not in range [99..101]")
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
        println("  $fiatAmount = ${fiatValues.joinToString(separator = " + ")}")
        val expected = fiatValues.reduce(BigDecimal::add)
        if (BalanceAssertManager.equal(fiatAmount, expected, 6)) {
            println("  - OK.")
        } else {
            println("  - FAILED. $fiatAmount <> $expected (scale = $scale)")
            isFailed = true
        }

        println()
        println(" Check 2. fiat.change = sum(wallet.fiat.change)")
        println("  $fiatChange = ${changeValues.joinToString(separator = " + ")}")
        val expectedChange = changeValues.reduce(BigDecimal::add)
        if (BalanceAssertManager.equal(fiatChange, expectedChange, 6)) {
            println("  - OK.")
        } else {
            println("  - FAILED. $fiatChange <> $expectedChange (scale = $scale)")
            isFailed = true
        }

        println()
        println(" Check 3. wallet.fiat[amount * changePercent / change] ~= 100%.")
        println("  $fiatAmount * $percent / $fiatChange ~= 100%")
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