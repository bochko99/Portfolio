package core;

import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import pojos.LoginModel;
import pojos.MobileVerification;
import utils.ConstantHelper;
import utils.EndPoints;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Auth {

    private static String defaultLogin = ConstantHelper.DEFAULT_LOGIN;
    private static String defaultPassword = ConstantHelper.DEFAULT_PASSWORD;

    public Auth() {
    }

    public static Auth basic(String defaultLogin, String defaultPassword) {
        Auth.defaultLogin = defaultLogin;
        Auth.defaultPassword = defaultPassword;
        return new Auth();
    }

    public static RequestSpecification auth(String login, String password) {

        List<Header> headers = given().spec(SpecStorage.commonRequestSpec())
                .body(new LoginModel().setLogin(login).setPassword(password))
                .when()
                .post(EndPoints.login)
                .then()
                .spec(SpecStorage.commonResponseSpec())
                .extract().headers().asList();

        if (headers.stream().noneMatch(h -> h.getName().equals(ConstantHelper.X_AUTHORIZATION))) {
            String code = given()
                    .baseUri(ConstantHelper.BETA)
                    .basePath(ConstantHelper.MANAGEMENT)
                    .queryParam("mobile", login)
                .when()
                    .get(EndPoints.testers_mobile)
                .then()
                    .statusCode(200)
                    .extract().body().as(MobileVerification.class).getCode();

            headers = given().spec(SpecStorage.commonRequestSpec()).body(new LoginModel().setLogin(login).setPassword(password).setCode(code))
                    .when().post(EndPoints.login_verify)
                    .then().statusCode(200).extract().headers().asList();
        }
        return given()
                .header(ConstantHelper.X_AUTHORIZATION, getHeaderValueByName(headers, ConstantHelper.X_AUTHORIZATION))
                .header(ConstantHelper.X_USER_ID, getHeaderValueByName(headers, ConstantHelper.X_USER_ID));
    }

    public static RequestSpecification auth() {
        return Auth.auth(defaultLogin, defaultPassword);
    }

    private static String getHeaderValueByName(List<Header> headers, String name) {
        Header matching = headers.stream().filter(h -> h.getName().equals(name)).findFirst().orElse(null);
        return matching == null ? "" : matching.getValue();
    }
}
