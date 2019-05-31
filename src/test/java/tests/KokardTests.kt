package tests

import com.crypterium.cryptApi.Auth
import com.crypterium.cryptApi.AuthProvider
import com.crypterium.cryptApi.pojos.cardorderoperation.OrderStatus
import com.crypterium.cryptApi.pojos.customerprofile.UserProfileModel
import com.crypterium.cryptApi.pojos.kokard.CardOrderModel
import com.crypterium.cryptApi.pojos.kokard.ResidentialAddress
import com.crypterium.cryptApi.utils.EndPoints
import core.TestScope
import core.annotations.Credentials
import core.annotations.ScopeTarget
import io.qameta.allure.*
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.response.ResponseBodyExtractionOptions
import org.junit.Ignore
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import tests.core.ExwalTest
import java.io.File
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt
import jdk.nashorn.internal.objects.NativeDate.getTime
import java.text.SimpleDateFormat
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import kotlin.random.nextLong


@Feature("Kokard")
@Epic(TestScope.REGRESS)
class KokardTests : ExwalTest() {

    inline fun <reified T> ResponseBodyExtractionOptions.to(): T {
        return this.`as`(T::class.java)
    }

    private val group = "FREE_CARD_PAID_DELIVERY"

    @Ignore
    @Test
    fun testUserForKokardCreation() {
        val result = mutableListOf<String>()
        repeat(1) {
            result.add(createUserForKokard().phone)
        }
        println(result.joinToString("\n"))
    }

    @ScopeTarget(ScopeTarget.Stand.BETA)
    @Story("New user process apply stage")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Credentials(creatingNewUser = true)
    fun processApply() {
        val doc = File(Thread.currentThread().contextClassLoader.getResource("photoforkyc/document.jpg")?.file)

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, (1..30).random())
        calendar.add(Calendar.MONTH, (1..12).random())
        calendar.add(Calendar.YEAR, -((18..69).random()))

        val birthday = SimpleDateFormat("yyyy-MM-dd").format(calendar.time)

        val user = createUserForKokard()
        val service = Auth.service<AuthProvider>()

        var cardOrder = service.auth().get(EndPoints.cardorder).to<CardOrderModel>()
        val firstname = user.firstName ?: "Jon"
        val lastname = user.lastName ?: "Snow"
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

    inline fun upload(service: AuthProvider, type: String, file: File, docNumber: String?) {
        service.auth()
                .header("Content-Type", "multipart/jpg")
                .queryParam("documentNumber", docNumber)
                .queryParam("documentType", type)
                .multiPart("image", file)
                .`when`().post(EndPoints.cardorder_upload_document)
    }

}