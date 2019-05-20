package tests.backcompatibility;

import com.crypterium.cryptApi.pojos.signupoperation.*;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import core.annotations.Credentials;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalV1Test;

import java.util.UUID;

import static com.crypterium.cryptApi.Auth.exauth;
import static com.crypterium.cryptApi.Auth.service;

public class SignupV1 extends ExwalV1Test {

    @Test
    @Credentials(creatingNewUser = true)
    @DisplayName("Register new user: Back compatibility")
    public void testRegisterV1() {
        AddName name = new AddName()
                .setFirstName("Test")
                .setLastName("Test");
        service().createUser().body(name).put(EndPoints.v1_mobile_name_add);

//        String email = "testirovshik182+test2@gmail.com";
        String email = "";
        for (int i = 0; i < 10; i++) {
            email = String.format("%s+test@%s.com",
                    RandomStringUtils.randomAlphabetic(5),
                    RandomStringUtils.randomAlphabetic(3)
            );
            VerifyEmail verifyEmail = new VerifyEmail()
                    .setEmail(email);
            int statusCode = service().auth().body(verifyEmail).expect().statusCode(Matchers.isOneOf(200, 400))
                    .when().post(EndPoints.v1_mobile_email_verify).statusCode();
            if (statusCode == 200) {
                break;
            }
        }

        String emailCode;
        switch (Environment.TARGET) {
            case "BETA":
                emailCode = "12321";
                break;
            default:
                emailCode = exauth().admin().queryParam("email", email)
                        .queryParam("event", "CRYPTERIUM_EMAIL_CONFIRM")
                        .get(EndPoints.admin_email_code).then().extract().body().jsonPath().getString("code");
        }

        ConfirmEmail confirmEmail = new ConfirmEmail()
                .setCode(emailCode);
        service().auth().body(confirmEmail).post(EndPoints.v1_mobile_email_confirm);

        Password password = new Password()
                .setPassword("12345a");
        service().auth().body(password).post(EndPoints.v1_mobile_pwd_setup);

        SetupPin setupPin = new SetupPin()
                .setPin("1111")
                .setFingerprint(UUID.randomUUID().toString());
        service().auth().body(setupPin).post(EndPoints.v1_mobile_pin_setup);
    }


}
