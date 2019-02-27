package com.crypterium.cryptApi.oldback;

import com.crypterium.cryptApi.AuthProvider;
import com.crypterium.cryptApi.oldback.pojos.LoginModel;
import com.crypterium.cryptApi.oldback.pojos.MobileVerification;
import com.crypterium.cryptApi.oldback.pojos.users.UsersLoginModel;
import com.crypterium.cryptApi.oldback.pojos.users.UsersProfilePinVerifyModel;
import com.crypterium.cryptApi.utils.Constants;
import com.crypterium.cryptApi.utils.EndPoints;
import com.crypterium.cryptApi.utils.Environment;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class CAuth extends AuthProvider {

    private String X_AUTH = "";
    private String X_USER_ID = "";
    public CAuth() {
    }

    @Override
    public void flush() {
        System.out.println("flush");
        X_AUTH = "";
        X_USER_ID = "";
    }

    public Map<String, String> getHeaders(String login, String password) {
        List<Header> headers = given()
                .body(new UsersLoginModel().setLogin(login).setPassword(password))
                .when()
                .post(EndPoints.users_login)
                .then()
                .extract().headers().asList();

        if (headers.stream().noneMatch(h -> h.getName().equals(Constants.X_AUTHORIZATION))) {
            String code = given()
                    .baseUri(Environment.MANAGEMENT_URL)
                    .basePath(Constants.MANAGEMENT)
                    .queryParam("mobile", login)
                    .when()
                    .get(EndPoints.testers_mobile)
                    .then()
                    .statusCode(200)
                    .extract().body().as(MobileVerification.class).getCode();

            headers = given().spec(SpecStorage.commonRequestSpec()).body(new LoginModel().setLogin(login).setPassword(password).setCode(code))
                    .when().post(EndPoints.users_login_verify)
                    .then().statusCode(200).extract().headers().asList();
            Header x_auth = headers.stream().filter(h -> h.getName().equalsIgnoreCase(Constants.X_AUTHORIZATION)).findFirst().orElse(new Header(Constants.X_AUTHORIZATION, ""));
            Header x_userId = headers.stream().filter(h -> h.getName().equalsIgnoreCase(Constants.X_USER_ID)).findFirst().orElse(new Header(Constants.X_USER_ID, ""));
            given().header(x_auth).header(x_userId).body((new UsersProfilePinVerifyModel()
                    .setPin("1111")))
                    .put(EndPoints.users_profile_pin_verify);

        }

        return headers.stream().collect(Collectors.toMap(Header::getName, Header::getValue, (k1, k2) -> k2));
    }


    @Override
    public RequestSpecification auth(String login, String password) {
        Map<String, String> headers = getHeaders(login, password);
        X_AUTH = headers.getOrDefault(Constants.X_AUTHORIZATION, "");
        X_USER_ID = headers.getOrDefault(Constants.X_USER_ID, "");
        return given()
                .header(Constants.X_AUTHORIZATION, X_AUTH)
                .header(Constants.X_USER_ID, X_USER_ID);
    }

    @Override
    public RequestSpecification auth() {
        if (X_AUTH.isEmpty() || X_USER_ID.isEmpty()) {
            Map<String, String> headers = getHeaders(defaultLogin, defaultPassword);
            X_AUTH = headers.getOrDefault(Constants.X_AUTHORIZATION, "");
            X_USER_ID = headers.getOrDefault(Constants.X_USER_ID, "");
        }
        System.out.println("UserID: " + X_USER_ID);
        return given()
                .header(Constants.X_AUTHORIZATION, X_AUTH)
                .header(Constants.X_USER_ID, X_USER_ID);
    }

    @Override
    public RequestSpecification createUser() {
        Headers headers = given().post(EndPoints.users_profile).then().extract().headers();
        X_AUTH = headers.get(Constants.X_AUTHORIZATION).getValue();
        X_USER_ID = headers.get(Constants.X_USER_ID).getValue();
        return given()
                .header(Constants.X_AUTHORIZATION, X_AUTH)
                .header(Constants.X_USER_ID, X_USER_ID);
    }

    @Override
    public RequestSpecification authSingle(String login, String password) {
        Map<String, String> headers = getHeaders(login, password);
        return given()
                .header(Constants.X_AUTHORIZATION, headers.getOrDefault(Constants.X_AUTHORIZATION, ""))
                .header(Constants.X_USER_ID, headers.getOrDefault(Constants.X_USER_ID, ""));
    }
}
