package tests.core;

import com.crypterium.cryptApi.Auth;
import com.crypterium.cryptApi.pojos.customerprofile.UserProfileModel;
import com.crypterium.cryptApi.pojos.signupoperation.SetupPin;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;

import java.util.UUID;

import static com.crypterium.cryptApi.Auth.service;

public class ExwalV1Test extends BaseTest {


    @BeforeAll
    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.exwal();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
        Auth.basic(Auth.AuthType.EXWAL_V1);
    }

    public UserProfileModel registerNewUser() {
        service().createUser();
        String email = ApiCommonFunctions.generateFreeEmail();
        SetupPin setupPin = new SetupPin()
                .setPin("1111")
                .setFingerprint(UUID.randomUUID().toString());
        service().auth().body(setupPin).post(EndPoints.mobile_pin_setup);

        return service().auth().get(EndPoints.customer_profile).as(UserProfileModel.class);
    }
}
