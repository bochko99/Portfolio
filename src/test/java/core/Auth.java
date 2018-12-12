package core;

import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import pojos.LoginModel;
import pojos.MobileVerification;
import utils.ConstantHelper;
import utils.EndPoints;
import utils.Environment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class Auth {

    private static String defaultLogin = Environment.BASE_LOGIN;
    private static String defaultPassword = Environment.BASE_PASSWORD;
    private static String X_AUTH = "";
    private static String X_USER_ID = "";


    public Auth() {
    }

    public static Auth basic(String defaultLogin, String defaultPassword) {
        Auth.defaultLogin = defaultLogin;
        Auth.defaultPassword = defaultPassword;
        return new Auth();
    }

    public static Map<String, String> getHeaders(String login, String password) {
        List<Header> headers = given()
                .body(new LoginModel().setLogin(login).setPassword(password))
                .when()
                .post(EndPoints.users_login)
                .then()
                .extract().headers().asList();

        if (headers.stream().noneMatch(h -> h.getName().equals(ConstantHelper.X_AUTHORIZATION))) {
            String code = given()
                    .basePath(ConstantHelper.MANAGEMENT)
                    .queryParam("mobile", login)
                    .when()
                    .get(EndPoints.testers_mobile)
                    .then()
                    .statusCode(200)
                    .extract().body().as(MobileVerification.class).getCode();

            headers = given().spec(SpecStorage.commonRequestSpec()).body(new LoginModel().setLogin(login).setPassword(password).setCode(code))
                    .when().post(EndPoints.users_login_verify)
                    .then().statusCode(200).extract().headers().asList();
        }
        return headers.stream().collect(Collectors.toMap(Header::getName, Header::getValue, (k1, k2) -> k2));
    }

    public static RequestSpecification auth(String login, String password) {
        Map<String, String> headers = getHeaders(login, password);
        X_AUTH = headers.getOrDefault(ConstantHelper.X_AUTHORIZATION, "");
        X_USER_ID = headers.getOrDefault(ConstantHelper.X_USER_ID, "");
        System.out.println(login + " : " + X_AUTH);
        return given()
                .header(ConstantHelper.X_AUTHORIZATION, X_AUTH)
                .header(ConstantHelper.X_USER_ID, X_USER_ID);
    }

    public static RequestSpecification auth() {
        if (X_AUTH.isEmpty() || X_USER_ID.isEmpty()) {
            Map<String, String> headers = getHeaders(defaultLogin, defaultPassword);
            X_AUTH = headers.getOrDefault(ConstantHelper.X_AUTHORIZATION, "");
            X_USER_ID = headers.getOrDefault(ConstantHelper.X_USER_ID, "");
            System.out.println(X_AUTH);
        }
        return given()
                .header(ConstantHelper.X_AUTHORIZATION, X_AUTH)
                .header(ConstantHelper.X_USER_ID, X_USER_ID);
    }

}
