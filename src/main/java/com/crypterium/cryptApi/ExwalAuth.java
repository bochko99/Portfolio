package com.crypterium.cryptApi;

import com.crypterium.cryptApi.pojos.signupoperation.ConfirmPhone;
import com.crypterium.cryptApi.utils.*;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class ExwalAuth extends AuthProvider {
    String accesstoken = "";
    String adminToken = "";

    Map<String, String> accesTokenCache = new HashMap<>();

    @Override
    public RequestSpecification authAs(String login, String password, String role) {
        if (accesTokenCache.containsKey(role)) {
            return SpecStorage.exwal().header("Authorization", "Bearer " + accesTokenCache.get(role));
        } else {
            String accessTokenSingle = SpecStorage.exwalOauth().queryParam("grant_type", "mobile_phone")
                    .queryParam("number", login)
                    .queryParam("password", password)
                    .post(EndPoints.token)
                    .then().extract().body().jsonPath().getString("access_token");
            accesTokenCache.put(role, accessTokenSingle);
            return SpecStorage.exwal().header("Authorization", "Bearer " + accessTokenSingle);
        }
    }

    @Override
    public RequestSpecification auth(String role) {
        if (accesTokenCache.containsKey(role)) {
            return SpecStorage.exwal().header("Authorization", "Bearer " + accesTokenCache.get(role));
        } else {
            CredentialEntry entry = Environment.CREDENTIALS.getOrDefault(role, null);
            if (entry == null) {
                entry = Environment.CREDENTIALS.get("default");
            }
            String newAccesToken = SpecStorage.exwalOauth().queryParam("grant_type", "mobile_phone")
                    .queryParam("number", entry.getLogin())
                    .queryParam("password", entry.getPassword())
                    .post(EndPoints.token)
                    .then().extract().body().jsonPath().getString("access_token");
            accesTokenCache.put(role, newAccesToken);
            return SpecStorage.exwal().header("Authorization", "Bearer " + newAccesToken);
        }
    }

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

        String smsCode = ApiCommonFunctions.getSmsCode(phoneNumber, "MOBILE_SIGN_UP");

        ConfirmPhone confirmPhone = new ConfirmPhone()
                .setPhone(phoneNumber)
                .setFingerprint(UUID.randomUUID().toString())
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
