package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.EndPoints;

import static io.restassured.RestAssured.given;

public class HotelsTests {

    @Test
    @DisplayName(EndPoints.hotels_search + " GET")
    public void testGetHotelsSearch() {
        given().get(EndPoints.hotels_search);
    }
    
}
