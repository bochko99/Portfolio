package tests.core;

import com.crypterium.cryptApi.Auth;
import com.crypterium.cryptApi.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.pojos.signupoperation.AddName;
import com.crypterium.cryptApi.pojos.signupoperation.ConfirmEmail;
import com.crypterium.cryptApi.pojos.signupoperation.Password;
import com.crypterium.cryptApi.pojos.signupoperation.SetupPin;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import java.util.UUID;

import static com.crypterium.cryptApi.Auth.exauth;
import static com.crypterium.cryptApi.Auth.service;

public class ExwalTest extends BaseTest {


    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.exwal();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
        Auth.basic(Auth.AuthType.EXWAL);
    }

    public UserProfileModel registerNewUser() {

        AddName name = new AddName()
                .setFirstName("Test")
                .setLastName("Test");
        service().createUser().body(name).put(EndPoints.mobile_name_add);

//        String email = "testirovshik182+test2@gmail.com";
        String email = ApiCommonFunctions.generateFreeEmail();

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
        service().auth().body(confirmEmail).post(EndPoints.mobile_email_confirm);

        Password password = new Password()
                .setPassword("12345a");
        service().auth().body(password).post(EndPoints.mobile_pwd_setup);

        SetupPin setupPin = new SetupPin()
                .setPin("1111")
                .setFingerprint(UUID.randomUUID().toString());
        service().auth().body(setupPin).post(EndPoints.mobile_pin_setup);

        return service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class);
    }
}
