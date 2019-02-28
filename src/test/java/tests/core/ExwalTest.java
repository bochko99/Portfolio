package tests.core;

import com.crypterium.cryptApi.newback.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.newback.pojos.signupoperation.*;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static com.crypterium.cryptApi.Auth.auth;
import static com.crypterium.cryptApi.Auth.createUser;

public class ExwalTest extends BaseTest {


    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.exwal();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    public UserProfileModel registerNewUser() {

        AddName name = new AddName()
                .setFirstName("Test")
                .setLastName("Test");
        createUser().body(name).put(EndPoints.mobile_name_add);
        String email = ApiCommonFunctions.generateFreeEmail();
        VerifyEmail verifyEmail = new VerifyEmail()
                .setEmail(email);
        auth().body(verifyEmail).post(EndPoints.mobile_email_verify);

        ConfirmEmail confirmEmail = new ConfirmEmail()
                .setCode("12321");
        auth().body(confirmEmail).post(EndPoints.mobile_email_confirm);

        Password password = new Password()
                .setPassword("123456");
        auth().body(password).post(EndPoints.mobile_pwd_setup);

        SetupPin setupPin = new SetupPin()
                .setPin("1111")
                .setFingerprint("ade713aa-bfa9-412d-a3d2-c39bfcea6e94");
        auth().body(setupPin).post(EndPoints.mobile_pin_setup);

        return auth().get(EndPoints.customer_profile).as(UserProfileModel.class);
    }
}
