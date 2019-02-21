package tests;

import io.qameta.allure.Step;
import pojos.CountryItem;
import pojos.users.*;
import tests.core.MobileTest;
import utils.*;

import static core.Auth.auth;
import static core.Auth.createUser;
import static io.restassured.RestAssured.given;
import static utils.SpecStorage.management;

public class NewUserTests extends MobileTest {


    @Step("Register user")
    protected String registerUser(Boolean isAustralian) {
        String email = ApiCommonFunctions.generateFreeEmail();
        String phone = ApiCommonFunctions.generateFreePhoneNumber();
        String password = "1234567";
        String pin = "1111";
        CountryItem country;
        UsersProfileModel body = new UsersProfileModel()
                .setEmail(email)
                .setMobile(phone)
                .setPassword(password)
                .setPin(pin)
                .setLogin("akjsdklkv")
                .setFirstName("Aleksandr")
                .setLastName("Tolstov");

        if (isAustralian) {
            country = new CountryItem();
            country.setName("Australia");
            body.setCitizenshipCountry("AU").setCitizenshipState("CX");
        } else {
            country = ApiCommonFunctions.getCountryByCode("RU");
            body.setCitizenshipCountry(country.getCode());
        }
        //create user by createUser and PUT data to it
        createUser()
                .body(body)
                .put(EndPoints.users_profile).then().extract().header(Constants.X_USER_ID);

        //verify
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
        auth()
                .body((new UsersProfilePinVerifyModel()
                        .setPin(pin)))
                .put(EndPoints.users_profile_pin_verify);

        auth()
                .body(new UsersProfilePasswordVerifyModel()
                        .setPassword(password))
                .put(EndPoints.users_profile_password_verify);

        ExcelWriter.getInstance().addToReport(1, Environment.TARGET, phone, email, password, country.getName(), userId);
        return userId;
    }

}