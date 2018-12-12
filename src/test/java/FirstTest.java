import core.SpecStorage;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import pojos.LoginModel;
import utils.EndPoints;

import static core.Auth.auth;
import static io.restassured.RestAssured.given;

public class FirstTest {

    @Before
    public void init() {
        System.out.println("Init");
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Test
    public void testAuth() {
        given().body(new LoginModel()
                        .setLogin("70000000040")
                        .setPassword("1234567"))
            .when()
                .post(EndPoints.users_login)
            .then()
                .statusCode(200);
    }

    @Test
    public void testFailedAuth() {
        RestAssured.responseSpecification = null;
        given().body(new LoginModel()
                        .setLogin("70000000040")
                        .setPassword("12345678"))
            .when()
                .post(EndPoints.users_login)
            .then()
                .statusCode(401);

    }

    @Test
    public void testInvoicesIban() {
        auth().post(EndPoints.invoices_iban);
    }

    @Test
    public void testInvoicesBpay() {
        auth().post(EndPoints.invoices_bpay);
    }

    @Test
    public void testInvoicesWithdraw() {
        auth().post(EndPoints.invoices_withdraw);
    }

}