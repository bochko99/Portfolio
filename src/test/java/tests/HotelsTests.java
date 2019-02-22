package tests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.MobileTest;

import static io.restassured.RestAssured.given;

public class HotelsTests extends MobileTest {

    @Test
    @DisplayName(EndPoints.hotels_search + " GET")
    public void testGetHotelsSearch() {
        given().get(EndPoints.hotels_search);
    }

}
