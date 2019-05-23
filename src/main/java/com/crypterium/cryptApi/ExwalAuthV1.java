package com.crypterium.cryptApi;

import com.crypterium.cryptApi.pojos.signupoperation.ConfirmPhone;
import com.crypterium.cryptApi.pojos.signupoperation.SignUpReqV1;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;

import java.util.Random;
import java.util.UUID;

import static io.restassured.RestAssured.given;

public class ExwalAuthV1 extends ExwalAuth {

    @Override
    public RequestSpecification createUser() {
        String phoneNumber = "";
        int statusCode;
        for (int i = 0; i < 10; i++) {
            //700000 00001-700000 29999

            phoneNumber = "700000" + new Random().nextInt(3) + RandomStringUtils.random(4, false, true);
            SignUpReqV1 signup = new SignUpReqV1()
                    .setPhone(phoneNumber)
                    .setCountry("RU")
                    .setRegion("");
            statusCode = given().body(signup).expect().statusCode(Matchers.isOneOf(200, 400))
                    .when().post(EndPoints.v1_mobile_signup).statusCode();
            if (statusCode == 200) {
                break;
            }
        }

        String smsCode;
        switch (Environment.TARGET) {
            case "BETA":
                smsCode = "12345";
                break;
            default:
                smsCode = admin().queryParam("phone", phoneNumber)
                        .queryParam("event", "MOBILE_SIGN_UP")
                        .get(EndPoints.admin_sms_code).then().extract().body().jsonPath().getString("code");
        }

        ConfirmPhone confirmPhone = new ConfirmPhone()
                .setPhone(phoneNumber)
                .setFingerprint(UUID.randomUUID().toString())
                .setSmsCode(smsCode);
        accesstoken = given().body(confirmPhone).post(EndPoints.v1_mobile_phone_confirm).then().extract().body().jsonPath().getString("access_token");
        System.out.println("Access token: " + accesstoken);

        return SpecStorage.exwal().header("Authorization", "Bearer " + accesstoken);
    }

}
