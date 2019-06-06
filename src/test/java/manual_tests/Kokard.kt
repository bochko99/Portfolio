package manual_tests

import com.crypterium.cryptApi.Auth
import com.crypterium.cryptApi.AuthProvider
import com.crypterium.cryptApi.pojos.cardorderoperation.OrderStatus
import com.crypterium.cryptApi.utils.EndPoints
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import tests.KokardTests
import tests.core.ExwalTest

class Kokard : ExwalTest() {

    /**
     * По номеру телефона присваивает пользователю группу (без авторизации)
     */
    @Test
    fun createOrderAndAssignGroup() {
        val phones = listOf("79161924811")
        val group = "FREE_CARD_FREE_DELIVERY"
        phones.forEach {
            Auth.service<AuthProvider>().admin()
                    .body("{\n" +
                            "    \"phone\": \"$it\",\n" +
                            "    \"experimentGroup\": \"$group\"\n" +
                            "}")
                    .put("/v1/temp/mobile/card/order/group")
        }
    }

    /**
     * Создает пользователя, готового к APPLY (статус APPLY)
     */
    @Disabled
    @Test
    fun testUserForKokardCreation() {
        val result = mutableListOf<String>()
        try {
            repeat(5) {
                result.add(KokardTests().createUserForKokard().phone)
            }
        } finally {
            println(result.joinToString("\n"))
        }

    }

    /**
     * Создает пользователя, прошедшего APPLY (статус REVIEW)
     */
    @Disabled
    @Test
    fun generateApply() {
        val result = mutableListOf<String>()
        try {
            repeat(5) {
                result.add(KokardTests().processApply().phone)
                Thread.sleep(15000)
            }
        } finally {
            println(result.joinToString("\n"))
        }

    }

    /**
     * Проверка, что многократный вызов методов, характерных для статуса ORDER, не меняет card_status
     */
    @Disabled
    @Test
    fun testStateDelivery() {
        val service = Auth.service<AuthProvider>()
        repeat(20) {
            val order = service.auth().get(EndPoints.mobile_card_order).to<OrderStatus>()
            service.auth().get(EndPoints.cardorder_tariffs)
            service.auth().pathParam("country", "RU").get(EndPoints.cardorder_freecard_delivery_country)
            assertAll(
                    { Assertions.assertEquals("APPROVED", order.cardApplyStatus) },
                    { Assertions.assertEquals("ORDER", order.cardStatus) },
                    { Assertions.assertEquals("NONE", order.cardOrderStatus) },
                    { Assertions.assertEquals("FREE_CARD_PAID_DELIVERY", order.cardOrderExperimentGroup) }
            )
        }
    }
}