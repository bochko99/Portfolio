package tests;

import core.Auth;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import pojos.users.UsersProfileKyc1Model;
import pojos.users.UsersProfileKyc2Model;
import utils.Constants;
import utils.EndPoints;
import utils.Environment;

import java.util.Collections;

import static core.Auth.auth;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class KycTests extends NewUserTests {

    @Test
    @DisplayName(("KYC 1 Returned"))
    public void testKYC1Completion() {
        String id = registerUser(false);

        UsersProfileKyc1Model model = new UsersProfileKyc1Model()
                .setType(UsersProfileKyc1Model.Type.DRIVER_LICENSE)
                .setFrontsideUrl("https://cdn.pbrd.co/images/HYxoyol.jpg")
                .setSelfieUrl("https://cdn.pbrd.co/images/HYwn7de.jpg");

        given()
                .baseUri(Environment.KYC_URL)
                .basePath("")
                .body(model)
                .header(Constants.X_USER_ID, id)
                .when()
                .post(EndPoints.identity)
                .then()
                .body("success", Matchers.equalTo(true));


        Auth.flush();
    }

    @Test
    @Ignore
    @DisplayName("KYC 2 Completion")
    public void testKYC2Completion() {
        String id = registerUser(false);

        UsersProfileKyc2Model model = new UsersProfileKyc2Model()
                .setRegistrationCountry("RU")
                .setRegistrationCity("Moscow")
                .setRegistrationStreet("Мясницкая")
                .setRegistrationZip("123456")
                .setRegistrationDocumentUrls(Collections.singletonList("https://s3-us-west-1.amazonaws.com/crypterium.mobile.upload.beta2/KYC1/DEBD6A60-6326-450D-AB5C-D0A453439FAF.jpg"));

        auth().body(model).put(EndPoints.users_profile_kyc2);
        auth().post(EndPoints.users_profile_kyc2_verify);
        auth().get(EndPoints.users_profile_kyc2).then().body("status", equalToIgnoringCase("SUBMITTED"));
        Auth.flush();
    }

}
