package tests.exwalltests;

import com.crypterium.cryptApi.newback.pojos.signupoperation.*;
import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.auth;
import static com.crypterium.cryptApi.Auth.createUser;
//import static com.c
import static io.restassured.RestAssured.given;

public class SignUp extends ExwalTest {

    @Test
    @DisplayName("Register new user")
    public void testRegisterNewUser() {

        AddName name = new AddName()
                .setFirstName("Test")
                .setLastName("Test");
        createUser().body(name).put(EndPoints.name_add);
        VerifyEmail verifyEmail = new VerifyEmail()
                .setEmail("oldtest77+161@gmail.com");
        auth().body(verifyEmail).post(EndPoints.email_verify);

        ConfirmEmail confirmEmail = new ConfirmEmail()
                .setCode("12321");
        auth().body(confirmEmail).post(EndPoints.email_confirm);

        Password password = new Password()
                .setPassword("123456");
        auth().body(password).post(EndPoints.password_setup);

        SetupPin setupPin = new SetupPin()
                .setPin("1111")
                .setFingerprint("ade713aa-bfa9-412d-a3d2-c39bfcea6e94");
        auth().body(setupPin).post(EndPoints.pin_setup);
    }


    @Test
    @DisplayName(EndPoints.phone_resend + " POST")
    public void testResendPhone() {
        ResendPhone resend = new ResendPhone()
                .setPhone("70000005469");
        given().body(resend).post(EndPoints.phone_resend);
    }

    @Test
    @DisplayName(EndPoints.email_resend + " POST")
    public void testResendEmailCode() {
        ResendEmail resendEmail = new ResendEmail()
                .setmEmail("oldtest77 + 160@gmail.com");

        given().body(resendEmail).post(EndPoints.email_resend);
    }


}