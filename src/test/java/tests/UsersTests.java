package tests;

import core.Auth;
import core.CommonFunctions;
import core.SpecStorage;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import pojos.CountryItem;
import pojos.users.*;
import utils.Constants;
import utils.EndPoints;
import utils.Environment;
import utils.ExcelWriter;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import static core.Auth.auth;
import static core.Auth.createUser;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class UsersTests {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

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
    public void testRegisterUser() {
        String id = registerUser();
        Assert.assertNotNull(id);
    }

    @Test
    @DisplayName(("KYC 1 Completion"))
    public void testKYC1Completion() {
        String id = registerUser();

        UsersProfileKyc1Model model = new UsersProfileKyc1Model()
                .setIdentificationDocument("Passport")
                .setIdentificationDocumentNumber("123456")
                .setIdentificationDocumentIssuedCountry("RU")
                .setIdentificationDocumentIssuedBy("Authority")
                .setIdentificationDocumentIssuedDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                .setIdentificationDocumentUrls(Collections.singletonList("https://s3-us-west-1.amazonaws.com/crypterium.mobile.upload.beta2/KYC1/DEBD6A60-6326-450D-AB5C-D0A453439FAF.jpg"))
                .setIdentificationDocumentSelfieUrls(Collections.singletonList("https://s3-us-west-1.amazonaws.com/crypterium.mobile.upload.beta2/KYC1/8876977C-6FE1-44C6-B9EE-2B698E55C2BA.jpg"));

        auth().body(model).put(EndPoints.users_profile_kyc1);
        auth().post(EndPoints.users_profile_kyc1_verify);
        auth().get(EndPoints.users_profile_kyc1).then().body("status", equalToIgnoringCase("SUBMITTED"));
        Auth.flush();
    }

    @Test
    @Ignore
    @DisplayName("KYC 2 Completion")
    public void testKYC2Completion() {
        String id = registerUser();

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
    @DisplayName(EndPoints.users_profile_kyc0 + " GET")
    public void testGetUsersProfileKyc0() {
        auth().get(EndPoints.users_profile_kyc0);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc1 + " GET")
    public void testGetUsersProfileKyc1() {
        auth().get(EndPoints.users_profile_kyc1);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc1_verify + " POST")
    public void testPostUsersProfileKyc1Verify() {
        auth().post(EndPoints.users_profile_kyc1_verify);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc2 + " GET")
    public void testGetUsersProfileKyc2() {
        auth().get(EndPoints.users_profile_kyc2);
    }

    @Test
    @DisplayName(EndPoints.users_profile_kyc2_verify + " POST")
    public void testPostUsersProfileKyc2Verify() {
        auth().post(EndPoints.users_profile_kyc2_verify);
    }

    @Step("Register user")
    private String registerUser() {
        String email = CommonFunctions.generateFreeEmail();
        String phone = CommonFunctions.generateFreePhoneNumber();
        CountryItem country = CommonFunctions.getRandomCountryByCryptoRestrictions(false);
        String password = "1234567";
        String pin = "1111";

        UsersProfileModel body = new UsersProfileModel()
                .setEmail(email)
                .setMobile(phone)
                .setCitizenshipCountry(country.getCode())
                .setPassword(password)
                .setPin(pin)
                .setLogin("akjsdklkv")
                .setFirstName("Hello1")
                .setLastName("World1");
        //create user by createUser and PUT data to it
        createUser()
                .body(body)
                .put(EndPoints.users_profile).then().extract().header(Constants.X_USER_ID);

        //verify
        String phoneConfirmationCode = given().basePath(Constants.MANAGEMENT).queryParam("mobile", phone).get(EndPoints.testers_mobile).body().jsonPath().getString("code");
        String emailConfirmationCode = given().basePath(Constants.MANAGEMENT).queryParam("email", email).get(EndPoints.testers_email).body().jsonPath().getString("code");
        given()
                .body(new UsersProfileMobileconfirmModel()
                        .setCode(phoneConfirmationCode)
                        .setMobile(phone))
                .post(EndPoints.users_profile_kyc0_mobile_confirm);
        String userId = given()
                .body(new UsersProfileEmailConfirmModel()
                        .setCode(emailConfirmationCode)
                        .setEmail(email))
                .post(EndPoints.users_profile_kyc0_email_confirm).then().extract().header(Constants.X_USER_ID);
        auth()
                .body((new UsersProfilePinVerifyModel()
                        .setPin(pin)))
                .put(EndPoints.users_profile_pin_verify);

        auth()
                .body(new UsersProfilePasswordVerifyModel()
                        .setPassword(password))
                .put(EndPoints.users_profile_password_verify);

        ExcelWriter.getInstance().addToReport(1, Environment.TARGET, phone, email, password, country.getName());
        return userId;
    }

}