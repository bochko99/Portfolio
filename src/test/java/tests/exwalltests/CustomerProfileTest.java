package tests.exwalltests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static com.crypterium.cryptApi.Auth.auth;
import static io.restassured.RestAssured.given;

public class CustomerProfileTest extends ExwalTest {

    @Test
    @DisplayName(EndPoints.profile + " GET")
    public void testProfile(){
        auth().get(EndPoints.profile);
    }

//
//    @Test
//    @DisplayName(EndPoints.profile + " put")
//    public void testProfilePUT(){
//        ProfileReq profileReq = new ProfileReq().setAgreePrivacyCheck()
//
//
//        auth().put(EndPoints.profile);
//    }

    @Test
    @DisplayName(EndPoints.loyality + " GET")
    public void testLoyality(){
        auth().get(EndPoints.loyality);
    }
}
