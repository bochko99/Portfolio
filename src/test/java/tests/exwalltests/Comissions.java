package tests.exwalltests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;
import tests.core.MobileTest;

import static io.restassured.RestAssured.given;

public class Comissions extends ExwalTest {

    @Test
    @DisplayName(EndPoints.comissions + " GET")
    public void testComissions(){
        given().get(EndPoints.comissions);
    }
}
