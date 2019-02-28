package com.crypterium.cryptApi.newback;

import com.crypterium.cryptApi.AuthProvider;
import com.crypterium.cryptApi.newback.pojos.signupoperation.ConfirmPhone;
import com.crypterium.cryptApi.newback.pojos.signupoperation.SignUpReq;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class ExwalAuth extends AuthProvider {
    String accesstoken = "";

    @Override
    public RequestSpecification auth(String login, String password) {
        accesstoken = SpecStorage.exwalOauth().queryParam("grant_type", "mobile_phone")
                .queryParam("number", login)
                .queryParam("password", password)
                .post(EndPoints.token)
                .then().extract().body().jsonPath().getString("access_token");
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
        return SpecStorage.exwal().header("Authorization", "Bearer " + accesstoken);
    }

    @Override
    public RequestSpecification createUser() {
        String phoneNumber = "";
        int statusCode = -1;
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            SignUpReq signup = new SignUpReq()
                    .setCountry("RU")
                    .setPhone(phoneNumber)
                    .setRegion("");
            statusCode = given().body(signup).post(EndPoints.mobile_signup).statusCode();
            if (statusCode == 200) {
                break;
            }
        }
        if (statusCode == 200) {
            ConfirmPhone confirmPhone = new ConfirmPhone()
                    .setPhone(phoneNumber)
                    .setFingerprint("ade713aa-bfa9-412d-a3d2-c39bfcea6e94")
                    .setSmsCode("12345");
            accesstoken = given().body(confirmPhone).post(EndPoints.mobile_phone_confirm).then().extract().body().jsonPath().getString("access_token");
            return SpecStorage.exwal().header("Authorization", "Bearer " + accesstoken);
        }
        else{
            throw new RuntimeException("Couldn't generate phone number after 10 attempts");
        }
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

    }
}
