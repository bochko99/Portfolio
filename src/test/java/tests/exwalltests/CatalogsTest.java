package tests.exwalltests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static io.restassured.RestAssured.given;

public class CatalogsTest extends ExwalTest {

    @Test
    @DisplayName(EndPoints.comissions + " GET")
    public void testComissions() {
        given().get(EndPoints.comissions);
    }


    @Test
    @DisplayName(EndPoints.countries_ex + " GET")
    public void testCountry() {
        given().get(EndPoints.countries);
    }


    @Test
    @DisplayName(EndPoints.catalog_currencies + " GET")
    public void testCurrencies() {
        given().get(EndPoints.catalog_currencies);
    }

    @Test
    @DisplayName(EndPoints.faq + " GET")
    public void testFAQ() {
        given().get(EndPoints.faq);
    }

    @Test
    @DisplayName(EndPoints.operations_ex + " GET")
    public void testOperations() {
        given().get(EndPoints.operations_ex);
    }

//    @Test
//    @DisplayName(EndPoints.operations_ex + " POST")
//    public void testOperationsPOST() {
//        OperationsReq operationsReq = new OperationsReq()
//                .setBeta()
//                .setConstraint()
//                .setEnabled()
//                .setName()
//                .setProvider();
//        given().body(operationsReq).post(EndPoints.operations_ex);
//    }
}
