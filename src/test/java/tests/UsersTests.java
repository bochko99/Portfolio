package tests;

import annotations.Credentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pojos.users.UsersProfileCheckModel;
import utils.EndPoints;

import static core.Auth.auth;
import static io.restassured.RestAssured.given;

public class UsersTests extends NewUserTests {

    @Test
    @DisplayName(EndPoints.users_profile + " GET")
    public void testGetUsersProfile() {
        auth().get(EndPoints.users_profile);
    }

    @Test
    @DisplayName(EndPoints.users_profile + " POST")
    public void testPostUsersProfile() {
        given().post(EndPoints.users_profile);
    }

    @Test
    @DisplayName("User registration")
    @Credentials(creatingNewUser = true)
    public void testRegisterUser() {
        String id = registerUser(true);
        Assert.assertNotNull(id);
    }

    @Test
    @DisplayName(EndPoints.users_profile_terms_agree + " POST")
    public void testPostUsersProfileTermsAgree() {
        auth().post(EndPoints.users_profile_terms_agree);
    }

    @Test
    @DisplayName(EndPoints.users_profile_terms_iban_agree + " POST")
    public void testPostUsersProfileTermsIbanAgree() {
        auth().post(EndPoints.users_profile_terms_iban_agree);
    }

    @Test
    @DisplayName(EndPoints.users_profile_loyalty + " GET")
    public void testGetUsersProfileLoyalty() {
        auth().get(EndPoints.users_profile_loyalty);
    }

    @Test
    @DisplayName(EndPoints.users_number + " GET")
    public void testGetUsersNumber() {
        given().pathParam("number", "4269550783").get(EndPoints.users_number);
    }

    @Test
    @DisplayName(EndPoints.users_profile_check + " POST")
    public void testPostUsersProfileCheck() {
        UsersProfileCheckModel model = new UsersProfileCheckModel().setEmail("oldtest77@gmail.com");
        given().body(model).post(EndPoints.users_profile_check);
    }

    @Test
    @DisplayName(EndPoints.users_logins + " POST")
    public void testPostUsersLogins() {
        auth().body(new String[]{"70000000001"}).post(EndPoints.users_logins);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc0 + " GET")
    public void testGetUsersProfileKyc0() {
        auth().get(EndPoints.users_profile_kyc0);
    }


}
