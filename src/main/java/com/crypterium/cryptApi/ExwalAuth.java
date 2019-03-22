package com.crypterium.cryptApi;

import com.crypterium.cryptApi.pojos.signupoperation.ConfirmPhone;
import com.crypterium.cryptApi.utils.ApiCommonFunctions;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.specification.RequestSpecification;

import static com.crypterium.cryptApi.Auth.exauth;
import static io.restassured.RestAssured.given;

public class ExwalAuth extends AuthProvider {
    private String accesstoken = "";
    private String adminToken = "";

    @Override
    public RequestSpecification auth(String login, String password) {
        accesstoken = SpecStorage.exwalOauth().queryParam("grant_type", "mobile_phone")
                .queryParam("number", login)
                .queryParam("password", password)
                .post(EndPoints.token)
                .then().extract().body().jsonPath().getString("access_token");
        System.out.println("Access token: " + accesstoken);

        return SpecStorage.exwal().header("Authorization", "Bearer " + accesstoken);
    }

    @Override
    public RequestSpecification auth() {
        if (accesstoken.isEmpty()) {
            accesstoken = SpecStorage.exwalOauth().queryParam("grant_type", "mobile_phone")
                    .queryParam("number", defaultLogin)
                    .queryParam("password", defaultPassword)
                    .post(EndPoints.token)
                    .then().extract().body().jsonPath().getString("access_token");
        }
        System.out.println("Access token: " + accesstoken);
        return SpecStorage.exwal().header("Authorization", "Bearer " + accesstoken);
    }

    @Override
    public RequestSpecification createUser() {
        String phoneNumber = ApiCommonFunctions.generateFreePhoneNumber();
        String smsCode = exauth().admin().queryParam("phone", phoneNumber)
                .queryParam("event", "MOBILE_SIGN_UP")
                .get(EndPoints.admin_sms_code).then().extract().body().jsonPath().getString("code");
        ConfirmPhone confirmPhone = new ConfirmPhone()
                .setPhone(phoneNumber)
                .setFingerprint("ade713aa-bfa9-412d-a3d2-c39bfcea6e94")
                .setSmsCode(smsCode);
        accesstoken = given().body(confirmPhone).post(EndPoints.mobile_phone_confirm).then().extract().body().jsonPath().getString("access_token");
        System.out.println("Access token: " + accesstoken);

        return SpecStorage.exwal().header("Authorization", "Bearer " + accesstoken);
    }

    @Override
    public RequestSpecification authSingle(String login, String password) {
        String accessTokenSingle = SpecStorage.exwalOauth().queryParam("grant_type", "mobile_phone")
                .queryParam("number", login)
                .queryParam("password", password)
                .post(EndPoints.token)
                .then().extract().body().jsonPath().getString("access_token");
        return SpecStorage.exwal().header("Authorization", "Bearer " + accessTokenSingle);
    }

    @Override
    public void flush() {
        adminToken = "";
        accesstoken = "";
    }

    public RequestSpecification admin() {
        if (adminToken.isEmpty()) {
            adminToken = SpecStorage.exwalOauth().queryParam("grant_type", "mobile_phone")
                    .queryParam("number", "70009999999")
                    .queryParam("password", "PXx7Gk8E")
                    .header("Authorization", "Basic c3VwcG9ydDpzdXBwb3J0XzFfMV9zZWNyZXQ=")
                    .post(EndPoints.token)
                    .then().extract().body().jsonPath().getString("access_token");
        }
        return SpecStorage.exwal().header("Authorization", "Bearer " + adminToken);
    }
}
