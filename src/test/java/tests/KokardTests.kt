package tests

import com.crypterium.cryptApi.Auth
import com.crypterium.cryptApi.Auth.service
import com.crypterium.cryptApi.AuthProvider
import com.crypterium.cryptApi.pojos.cardorderoperation.OrderStatus
import com.crypterium.cryptApi.pojos.customerprofile.UserProfileModel
import com.crypterium.cryptApi.pojos.kokard.*
import com.crypterium.cryptApi.pojos.wallets.Currency.*
import com.crypterium.cryptApi.utils.ApiCommonFunctions.generateFirstName
import com.crypterium.cryptApi.utils.ApiCommonFunctions.generateLastName
import com.crypterium.cryptApi.utils.BalanceAssertManager.assertClose
import com.crypterium.cryptApi.utils.EndPoints
import core.TestScope
import core.annotations.Credentials
import core.annotations.ScopeTarget
import io.qameta.allure.*
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.response.ResponseBodyExtractionOptions
import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DynamicContainer.dynamicContainer
import org.junit.jupiter.api.DynamicTest.dynamicTest
import tests.core.ExwalTest
import java.io.File
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*
import java.util.stream.Stream
import kotlin.random.Random
import kotlin.random.nextInt


@Feature("Kokard")
@Epic(TestScope.REGRESS)
class KokardTests : ExwalTest() {

    inline fun <reified T> ResponseBodyExtractionOptions.to(): T {
        return this.`as`(T::class.java)
    }

    private val group = "FREE_CARD_FREE_DELIVERY"

    @Story("Payload data tests")
    @Severity(SeverityLevel.NORMAL)
    @TestFactory
    fun payloadDataTests(): Collection<DynamicNode> {
        val pairs = listOf(BTC, ETH, LTC)
        return pairs.map {
            val currency = it
            val data = service<AuthProvider>().auth().pathParam("currency", it).get(EndPoints.card_payload_currency_data).to<PayloadCurrencyData>()
            dynamicContainer("Data min/max. $currency",
                    Stream.of<DynamicTest>(
                            dynamicTest("counter min ~= rate * base min. $currency") {
                                val from = data.fromLimits.min
                                val to = data.toLimits.min
                                val rate = data.params.rate.value

                                assertThat("fromMin > 0", from, greaterThan(ZERO))
                                assertThat("toMin > 0", to, greaterThan(ZERO))
                                assertThat("rate > 0", rate, greaterThan(ZERO))

                                val expectedMin = from.multiply(rate)
                                val msgMin = "$from * $rate"

                                assertClose(msg = msgMin, expected = expectedMin, actual = to)
                            },
                            dynamicTest("counter max ~= rate * base max. $currency") {
                                val from = data.fromLimits.max
                                val to = data.toLimits.max
                                val rate = data.params.rate.value

                                assertThat("fromMax > 0", from, greaterThan(ZERO))
                                assertThat("toMax > 0", to, greaterThan(ZERO))
                                assertThat("rate > 0", rate, greaterThan(ZERO))

                                val expectedMax = from.multiply(rate)
                                val msgMax = "$from * $rate"
                                assertClose(msg = msgMax, expected = expectedMax, actual = to)
                            }
                    ))
        }
    }


    @Severity(SeverityLevel.NORMAL)
    @Story("Rate differentiation")
    @Description("Difference between rates from exchange_currencies and zero offer should be less than 1%")
    @TestFactory
    fun payloadOfferRateDifferentation(): Collection<DynamicNode> {
        val pairs = listOf(BTC, ETH, LTC)
        return pairs.map {
            dynamicTest("Rate differentiation: $it") {
                val data = service<AuthProvider>().auth().pathParam("currency", it).get(EndPoints.card_payload_currency_data).to<PayloadCurrencyData>()
                val body = PayloadOffer(
                        amount = Amount(
                                currency = it,
                                value = data.fromLimits.min.multiply(BigDecimal("0.95"))
                        ),
                        fromCurrency = it,
                        toCurrency = data.params.rate.currency
                )

                val response = service<AuthProvider>().auth().body(body).post(EndPoints.card_payload_offer_create)
                        .to<PayloadOfferResponse>()

                val differentiationPercent = data.params.rate.value.subtract(response.params.rate.value)
                        ?.divide(data.params.rate.value, 6, RoundingMode.HALF_UP)
                        ?.multiply(BigDecimal("100"))

                println(data.params.rate.value)
                println(response.params.rate.value)
                println(differentiationPercent)

                assertAll(
                        { assertThat("Rate differ", differentiationPercent?.abs(), lessThan(BigDecimal("1"))) },
                        { assertThat("Amount equality", response.from.value, equalTo(body.amount.value)) },
                        { assertClose("Load fee = 1%", response.params.fee.value, body.amount.value.multiply(data.params.fee.value)) },
                        { assertClose("Gas fee = 0.5%", response.params.gasFee.value, body.amount.value.multiply(data.params.gasFee.value)) }
                )
            }
        }
    }

    @ScopeTarget(ScopeTarget.Stand.BETA)
    @Story("New user process apply stage")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Credentials(creatingNewUser = true)
    fun processApply(): UserProfileModel {
        val doc = File(Thread.currentThread().contextClassLoader.getResource("photoforkyc/document.jpg")?.file)

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, (1..30).random())
        calendar.add(Calendar.MONTH, (1..12).random())
        calendar.add(Calendar.YEAR, -((20..69).random()))

        val birthday = SimpleDateFormat("yyyy-MM-dd").format(calendar.time)

        val user = createUserForKokard()
        val service = Auth.service<AuthProvider>()

        var cardOrder = service.auth().get(EndPoints.cardorder).to<CardOrderModel>()
        val firstname = generateFirstName()
        val lastname = generateLastName()
        val nationality = cardOrder.nationality ?: "RU"

        // Identity data
        service.auth()
                .body(CardOrderModel(
                        dateOfBirth = birthday,
                        firstName = firstname,
                        lastName = lastname,
                        nationality = nationality
                ))
                .put(EndPoints.cardorder_update)

        cardOrder = service.auth().get(EndPoints.cardorder).to()
        assertAll("Identity data checks",
                { assertNotNull(cardOrder.firstName) },
                { assertNotNull(cardOrder.lastName) },
                { assertEquals(firstname, cardOrder.firstName) },
                { assertEquals(lastname, cardOrder.lastName) },
                { assertEquals(nationality, cardOrder.nationality) },
                { assertTrue(cardOrder.documentsAndDataStatus?.identity?.data ?: false) }
        )

        // Identity docs
        upload(service, "DRIVER_LICENCE", doc, "12345678")
        upload(service, "DRIVER_LICENCE_BACKSIDE", doc, "12345678")
        upload(service, "SELFIE_PHOTO", doc, "12345678")
        cardOrder = service.auth().get(EndPoints.cardorder).to()
        assertAll("Identity docs checks",
                { assertTrue(cardOrder.documentsAndDataStatus?.identity?.document ?: false) },
                { assertTrue(cardOrder.documentsAndDataStatus?.identity?.documentBackside ?: false) }
        )

        // Residence data
        val expected = ResidentialAddress(
                address = "Address string ${Random.nextInt(1..1000000)}",
                city = "City string ${Random.nextInt(1..1000000)}",
                country = "RU",
                postalCode = "${Random.nextInt(1..1000000)}"
        )

        service.auth()
                .body(CardOrderModel(
                        residentialAddress = expected
                )).put(EndPoints.cardorder_update)

        cardOrder = service.auth().get(EndPoints.cardorder).to()
        val residentialAddress = cardOrder.residentialAddress
        assertAll("Residence data checks",
                { assertEquals(expected.address, residentialAddress?.address) },
                { assertEquals(expected.city, residentialAddress?.city) },
                { assertEquals(expected.country, residentialAddress?.country) },
                { assertEquals(expected.postalCode, residentialAddress?.postalCode) },
                { assertTrue(cardOrder.documentsAndDataStatus?.residence?.data ?: false) },

                { assertFalse(cardOrder.documentsAndDataStatus?.residence?.document ?: true) }
        )

        // Residence docs
        upload(service, "RECENT_UTILITY_BILL", doc, null)
        cardOrder = service.auth().get(EndPoints.cardorder).to()
        assertAll("Residence docs checks",
                { assertTrue(cardOrder.documentsAndDataStatus?.residence?.document ?: false) },
                { assertTrue(cardOrder.documentsAndDataStatus?.residence?.documentBackside ?: false) }
        )

        // Sign doc
        upload(service, "SPECIMEN_SIGNATURE", doc, null)
        cardOrder = service.auth().get(EndPoints.cardorder).to()
        assertAll("Signature docs checks",
                { assertTrue(cardOrder.documentsAndDataStatus?.signature?.data ?: false) },
                { assertTrue(cardOrder.documentsAndDataStatus?.signature?.document ?: false) },
                { assertTrue(cardOrder.documentsAndDataStatus?.signature?.documentBackside ?: false) }
        )

        service.auth().post(EndPoints.cardorder_apply)
        val status = service.auth().get(EndPoints.mobile_card_order).to<OrderStatus>()
        assertAll("Apply checks",
                { assertEquals("REVIEW", status.cardApplyStatus) },
                { assertEquals("APPLY", status.cardStatus) },
                { assertEquals("NONE", status.cardOrderStatus) }
        )

        return user

    }

    fun createUserForKokard(): UserProfileModel {

        val user = registerNewUser()
        val service = Auth.service<AuthProvider>()

        // email verification
        val codeValue = service.admin()
                .queryParam("email", user.email)
                .queryParam("event", "EMAIL_ADD")
                .get(EndPoints.admin_email_code).then().extract().body().jsonPath().getString("code")

        val token = Base64.getEncoder().encodeToString(codeValue.toByteArray())
        val emailBase64 = Base64.getEncoder().encodeToString(user.email.toByteArray())
        service.auth()
                .noFiltersOfType(ResponseLoggingFilter::class.java)
                .pathParam("token", token)
                .queryParam("email", emailBase64)
                .queryParam("event", "RU1BSUxfQURE")
                .get(EndPoints.mobile_email_confirm)

        //card order
        service.auth().post(EndPoints.mobile_card_order)

        //changing the group
        service.auth().pathParam("group", group).put(EndPoints.temp_mobile_card_order_group)
        return user
    }

    private fun upload(service: AuthProvider, type: String, file: File, docNumber: String?) {
        service.auth()
                .header("Content-Type", "multipart/jpg")
                .queryParam("documentNumber", docNumber)
                .queryParam("documentType", type)
                .multiPart("image", file)
                .`when`().post(EndPoints.cardorder_upload_document)
    }

}