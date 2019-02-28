package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.signupoperation.*;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.EndPoints;
import core.annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import tests.core.ExwalTest;

import java.util.Random;

import static com.crypterium.cryptApi.Auth.auth;

import static com.crypterium.cryptApi.Auth.createUser;
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
        int statusCode = -1;
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            SignUpReq signup = new SignUpReq()
                    .setCountry("RU")
                    .setPhone(phoneNumber)
                    .setRegion("");
            statusCode = given().body(signup).post(EndPoints.mobile_signup).statusCode();
            if (statusCode == 200) {
                break;
            }
        }
        ResendPhone resend = new ResendPhone()
                .setPhone(phoneNumber);
        auth().body(resend).post(EndPoints.mobile_phone_resend);
    }

    @Test
    @DisplayName(EndPoints.mobile_email_resend + " POST")
    public void testResendEmailCode() {
        createUser();
        String email = ApiCommonFunctions.generateFreeEmail();
        ResendEmail resendEmail = new ResendEmail()
                .setEmail(email);

       auth().body(resendEmail).post(EndPoints.mobile_email_resend);
    }


}