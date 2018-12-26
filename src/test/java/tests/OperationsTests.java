package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import pojos.operations.OperationModel;
import pojos.operations.OperationsCommentModel;
import utils.EndPoints;

import java.text.SimpleDateFormat;
import java.util.Date;

import static core.Auth.auth;
import static org.hamcrest.Matchers.equalTo;

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
    @DisplayName(EndPoints.operations_id_comment + " ")
    public void testOperationsIdComment() {
        String message = "Test message - " + new SimpleDateFormat("dd.MM.yyyy HH24:mm:ss").format(new Date());
        OperationsCommentModel model = new OperationsCommentModel().setComment(message);
        OperationModel[] operations = auth().queryParam("take", 1).get(EndPoints.operations).as(OperationModel[].class);
        String id = operations[0].getId();
        auth().pathParam("id", id).body(model).post(EndPoints.operations_id_comment);
        auth().queryParam("take", 5).get(EndPoints.operations).then()
                .body("find {it.id == '" + id + "'}.comment", equalTo(message));
    }

    @Test
    @DisplayName(EndPoints.operations_read + " POST")
    public void testPostOperationsRead() {
        auth().post(EndPoints.operations_read);
    }

}
