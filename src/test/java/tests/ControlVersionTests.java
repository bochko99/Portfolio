package tests;

import com.crypterium.cryptApi.utils.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import tests.core.ExwalTest;

import static io.restassured.RestAssured.given;

public class ControlVersionTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.ex_settings_version + " GET")
    public void testComissions(){
        given().header("User-Agent","Crypterium/1.7.0 (Android; 26): samsung SM-A530F")
                .get(EndPoints.ex_settings_version);
    }

//    @Test
//    @DisplayName(EndPoints.ex_settings_version + " GET")
//    public void testComissions406(){
//        given().header("User-Agent","Crypterium/1.6.5 (Android; 26): samsung SM-A530F")
//                .get(EndPoints.ex_settings_version);
//    }
}
