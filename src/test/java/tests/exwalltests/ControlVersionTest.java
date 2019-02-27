package tests.exwalltests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static io.restassured.RestAssured.given;

public class ControlVersionTest extends ExwalTest {

    @Test
    @DisplayName(EndPoints.version + " GET")
    public void testComissions(){
        given().header("User-Agent","Crypterium/1.6.2 (Android; 26): samsung SM-A530F")
                .get(EndPoints.version);
    }
}
