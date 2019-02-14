package tests;

import core.CommonFunctions;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pojos.users.UsersProfileEmailConfirmModel;
import pojos.users.UsersProfileMobileconfirmModel;
import pojos.users.UsersProfileModel;
import tests.core.MobileTest;
import utils.Constants;
import utils.EndPoints;
import utils.Environment;

import static core.Auth.auth;
import static core.Auth.createUser;
import static core.SpecStorage.gl;
import static core.SpecStorage.management;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BitGoTest extends MobileTest {

    @Test
    @DisplayName("Wallets for new users")
    public void testCreateWallets() {

        String email = CommonFunctions.generateFreeEmail();
        String phone = CommonFunctions.generateFreePhoneNumber();
        String password = "1234567";
        String pin = "1111";
        UsersProfileModel body = new UsersProfileModel()
                .setEmail(email)
                .setMobile(phone)
                .setPassword(password)
                .setPin(pin)
                .setLogin("akjsdklkv")
                .setFirstName("Aleksandr")
                .setLastName("Tolstov")
                .setCitizenshipCountry("RU");

        createUser()
                .body(body)
                .put(EndPoints.users_profile).then().extract().header(Constants.X_USER_ID);

        String phoneConfirmationCode = management()
                .queryParam("mobile", phone)
                .get(EndPoints.testers_mobile).body().jsonPath().getString("code");

        String emailConfirmationCode = management()
                .queryParam("email", email)
                .get(EndPoints.testers_email).body().jsonPath().getString("code");

        given()
                .body(new UsersProfileMobileconfirmModel()
                        .setCode(phoneConfirmationCode)
                        .setMobile(phone))
                .post(EndPoints.users_profile_mobile_confirm);

        String userId = given()
                .body(new UsersProfileEmailConfirmModel()
                        .setCode(emailConfirmationCode)
                        .setEmail(email))
                .post(EndPoints.users_profile_email_confirm).then().extract().header(Constants.X_USER_ID);

        int expectedCount = Integer.parseInt(Environment.GL_EXPECTED_ACCOUNT_COUNT);

        gl().queryParam("ownerExternalId", userId)
                .get(EndPoints.account_records)
                .then().body("size()", equalTo(expectedCount));

        auth().get(EndPoints.fundswallets).then().body("size()", equalTo(4));
    }

}
