package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;

public class OperationsTests {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Test
    @DisplayName(EndPoints.operations + " GET")
    public void testGetOperations() {
        auth().get(EndPoints.operations);
    }

    @Test
    @DisplayName(EndPoints.operations_read + " POST")
    public void testPostOperationsRead() {
        auth().post(EndPoints.operations_read);
    }

}
