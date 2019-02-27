package tests;

import com.crypterium.cryptApi.oldback.pojos.users.UsersProfileEmailConfirmModel;
import com.crypterium.cryptApi.oldback.pojos.users.UsersProfileMobileconfirmModel;
import com.crypterium.cryptApi.oldback.pojos.users.UsersProfileModel;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.Constants;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.MobileTest;

import static com.crypterium.cryptApi.Auth.auth;
import static com.crypterium.cryptApi.Auth.createUser;
import static com.crypterium.cryptApi.utils.SpecStorage.gl;
import static com.crypterium.cryptApi.utils.SpecStorage.management;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BitGoTest extends MobileTest {

    @Test
    @DisplayName("Wallets for new users")
    public void testCreateWallets() {

        String email = ApiCommonFunctions.generateFreeEmail();
        String phone = ApiCommonFunctions.generateFreePhoneNumber();
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
