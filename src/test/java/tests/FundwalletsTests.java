package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;

public class FundwalletsTests {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Test
    @DisplayName(EndPoints.fundswallets + " GET")
    public void testGetFundswallets() {
        auth().get(EndPoints.fundswallets);
    }

}
