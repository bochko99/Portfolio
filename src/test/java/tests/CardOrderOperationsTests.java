package tests;

import com.crypterium.cryptApi.pojos.cardorderoperation.OrderReq;
import com.crypterium.cryptApi.pojos.signupoperation.SignUpReq;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import tests.core.ExwalTest;

import java.util.Random;

import static com.crypterium.cryptApi.Auth.service;
import static io.restassured.RestAssured.given;

public class CardOrderOperationsTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.card_order + " POST")
    public void testCardWeb() {
        String phoneNumber = "";
        int statusCode = -1;
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            SignUpReq signup = new SignUpReq()
                    .setPhone(phoneNumber);
            statusCode = given().body(signup).post(EndPoints.mobile_signup).statusCode();
            if (statusCode == 200) {
                break;
            }

        }
        String email = ApiCommonFunctions.generateFreeEmail();
        OrderReq orderReq = new OrderReq()
                .setCountry("RU")
                .setEmail(email)
                .setPhone(phoneNumber)
                .setName("Vasya");
        given().body(orderReq).post(EndPoints.card_order);

    }

    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName(EndPoints.mobile_card_order + " POST")
    public void testCardOrderPost() {
        registerNewUser();
        service().auth().post(EndPoints.mobile_card_order);
    }

    @Test
    @DisplayName(EndPoints.mobile_card_order + " GET")
    public void testCardOrderGet() {
        service().auth().get(EndPoints.mobile_card_order);
    }
}
