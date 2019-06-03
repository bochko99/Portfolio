package manual_tests

import com.crypterium.cryptApi.Auth.service
import com.crypterium.cryptApi.AuthProvider
import com.crypterium.cryptApi.pojos.catalogs.CatalogCurrency
import com.crypterium.cryptApi.pojos.customerprofile.ProfileReq
import com.crypterium.cryptApi.pojos.wallets.Wallet
import com.crypterium.cryptApi.pojos.wallets.WalletListResp
import com.crypterium.cryptApi.utils.BalanceAssertManager
import com.crypterium.cryptApi.utils.EndPoints
import com.crypterium.cryptApi.utils.SpecStorage
import core.annotations.Credentials
import io.restassured.response.ResponseBodyExtractionOptions
import org.junit.Assert
import org.junit.Assume
import org.junit.jupiter.api.*
import org.junit.jupiter.api.DynamicContainer.dynamicContainer
import org.junit.jupiter.api.DynamicTest.dynamicTest
import tests.core.ExwalTest
import java.math.BigDecimal
import java.math.RoundingMode

inline fun <reified T> ResponseBodyExtractionOptions.to(): T {
    return this.`as`(T::class.java)
}

class FiatWalletChecks : ExwalTest() {

    @Credentials(creatingNewUser = true)
    @Test
    fun createUsers() {
        val result = mutableListOf<String>()
        repeat(10) {
            result.add(registerNewUser().phone)
        }
        println(result.joinToString(separator = "\n"))
    }

    private val scale = 6

    @TestFactory
    fun fiatTests(): Collection<DynamicNode> {
        val currencies = SpecStorage.exwal().get(EndPoints.catalog_currencies).to<Array<CatalogCurrency>>()
        val responses = currencies.map {
            service<AuthProvider>().auth().body(ProfileReq().setPrimaryCurrency(it.code)).put(EndPoints.customer_profile)
            it to service<AuthProvider>().auth().get(EndPoints.wallet_list).to<WalletListResp>()
        }
        return responses.map {
            createScope(it)
        }

    }

    private fun createScope(it: Pair<CatalogCurrency, WalletListResp>): DynamicNode {
        return dynamicContainer(it.first.code, listOf(
                dynamicContainer("Wallet checks", it.second.wallets.map {
                    createWalletTests(it)
                }),
                dynamicContainer("Overall checks", createFinishTests(it.second))
        ))
    }

    private fun createWalletTests(wallet: Wallet): DynamicContainer {
        val fiatAmount = wallet.fiat.amount
        val balance = wallet.balance
        val rate = wallet.fiat.rate
        val changePercent = wallet.fiat.changePercent
        val change = wallet.fiat.change

        return dynamicContainer(wallet.currency.name, listOf<DynamicTest>(
                dynamicTest("Check 1. wallet.fiat.amount / (wallet.balance * wallet.fiat.rate) ~= 1 +- delta") {
                    Assume.assumeTrue("Balance is 0", balance > BigDecimal.ZERO)
                    Assume.assumeTrue("Rate is 0", rate.compareTo(BigDecimal.ZERO) != 0)
                    val calculated = fiatAmount.divide(balance.multiply(rate), 20, RoundingMode.HALF_UP)
                    val delta = BigDecimal("0.01").divide(rate, 20, RoundingMode.HALF_UP)

                    val low = BigDecimal.ONE.minus(delta)
                    val up = BigDecimal.ONE.plus(delta)
                    println("${fiatAmount.toPlainString()} / (${balance.toPlainString()} * ${rate.toPlainString()}) ~= 1 +- ${delta.toPlainString()}")
                    Assert.assertTrue("${calculated.toPlainString()} not in range [${low.toPlainString()}, ${up.toPlainString()}]",
                            calculated >= low && calculated <= up)
                },
                dynamicTest("Check 2. wallet.fiat[amount * changePercent / change] ~= 100%.") {
                    Assume.assumeTrue("Balance is 0", balance > BigDecimal.ZERO)
                    Assume.assumeTrue("Change is 0", change.compareTo(BigDecimal.ZERO) != 0)
                    println("${fiatAmount.toPlainString()} * ${changePercent.toPlainString()} / ${change.toPlainString()} ~= 100%")
                    val expectedPercent = fiatAmount.multiply(changePercent).divide(change, 2, RoundingMode.HALF_UP)
                    Assert.assertTrue("${expectedPercent.toPlainString()} not in range [99..101]", expectedPercent.toInt() in 99..101)
                }
        ))
    }

    private fun createFinishTests(resp: WalletListResp): Collection<DynamicTest> {
        val fiatAmount = resp.fiat.amount
        val fiatChange = resp.fiat.change
        val percent = resp.fiat.changePercent
        val fiatValues = resp.wallets.map { it.fiat.amount }
        val changeValues = resp.wallets.map { it.fiat.change }

        return listOf(
                dynamicTest("Check 1. fiat.amount = sum(wallet.fiat.amount)") {
                    println("  ${fiatAmount.toPlainString()} = ${fiatValues.joinToString(separator = " + ")}")
                    val expected = fiatValues.reduce(BigDecimal::add)
                    Assert.assertTrue("$fiatAmount <> $expected (scale = $scale)", BalanceAssertManager.equal(fiatAmount, expected, scale))
                },
                dynamicTest("Check 2. fiat.change = sum(wallet.fiat.change)") {
                    println("  ${fiatChange.toPlainString()} = ${changeValues.joinToString(separator = " + ")}")
                    val expectedChange = changeValues.reduce(BigDecimal::add)
                    Assert.assertTrue("FAILED. $fiatChange <> $expectedChange (scale = $scale)", BalanceAssertManager.equal(fiatChange, expectedChange, scale))
                },
                dynamicTest("Check 3. fiat[amount * changePercent / change] ~= 100%.") {
                    println("  ${fiatAmount.toPlainString()} * ${percent.toPlainString()} / ${fiatChange.toPlainString()} ~= 100%")
                    val expectedPercent = fiatAmount.multiply(percent).divide(fiatChange, 2, RoundingMode.HALF_UP)
                    Assert.assertTrue("FAILED. $expectedPercent not in range [99..101]", expectedPercent.toDouble() in 99..101)
                }
        )
    }

}