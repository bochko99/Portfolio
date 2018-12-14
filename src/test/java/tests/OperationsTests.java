package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.EndPoints;

import static core.Auth.auth;

public class OperationsTests {

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
