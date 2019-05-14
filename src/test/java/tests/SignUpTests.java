package tests;

import com.crypterium.cryptApi.pojos.signupoperation.ResendEmail;
import com.crypterium.cryptApi.pojos.signupoperation.ResendPhone;
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

public class SignUpTests extends ExwalTest {

    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName("Register new user")
    public void testRegisterNewUser() {

        registerNewUser();
    }


    @Test
    @DisplayName(EndPoints.mobile_phone_resend + " POST")
    public void testResendPhone() {
        String phoneNumber = "";
        int statusCode;
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            SignUpReq signup = new SignUpReq()
                    .setPassword("12345a")
                    .setPhone(phoneNumber);
            statusCode = given().body(signup).post(EndPoints.mobile_signup).statusCode();
            if (statusCode == 200) {
                break;
            }
        }
        ResendPhone resend = new ResendPhone()
                .setPhone(phoneNumber);
        given().body(resend).post(EndPoints.mobile_phone_resend);
    }

    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName(EndPoints.mobile_email_resend + " POST")
    public void testResendEmailCode() {
        service().createUser();
        String email = ApiCommonFunctions.generateFreeEmail();
        ResendEmail resendEmail = new ResendEmail()
                .setEmail(email);

        service().auth().body(resendEmail).post(EndPoints.mobile_email_resend);
    }


}