package tests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static io.restassured.RestAssured.given;

public class CatalogsTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.catalog_comissions + " GET")
    public void testComissions() {
        given().get(EndPoints.catalog_comissions);
    }


    @Test
    @DisplayName(EndPoints.catalog_countries + " GET")
    public void testCountry() {
        given().get(EndPoints.catalog_countries);
    }


    @Test
    @DisplayName(EndPoints.catalog_currencies + " GET")
    public void testCurrencies() {
        given().get(EndPoints.catalog_currencies);
    }

    @Test
    @DisplayName(EndPoints.catalog_faq + " GET")
    public void testFAQ() {
        given().get(EndPoints.catalog_faq);
    }

    @Test
    @DisplayName(EndPoints.catalogs_operations_ex + " GET")
    public void testOperations() {
        given().get(EndPoints.catalogs_operations_ex);
    }


}
