package tests;

import core.SpecStorage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.EndPoints;

import static io.restassured.RestAssured.given;

public class HotelsTests {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }


    @Test
    @DisplayName(EndPoints.hotels_search + " GET")
    public void testGetHotelsSearch() {
        given().get(EndPoints.hotels_search);
    }
    
}
