package tests;

import com.crypterium.cryptApi.utils.EndPoints;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import tests.core.ExwalTest;

import static io.restassured.RestAssured.given;

public class ApiVersionControllerTests extends ExwalTest {

    @Test
    @DisplayName(EndPoints.ex_settings_version + " GET : 200")
    public void testComissions() {
        given().header("User-Agent", "Crypterium/1.7.0 (Android; 26): samsung SM-A530F")
                .get(EndPoints.ex_settings_version);
    }

    @Test
    @DisplayName(EndPoints.ex_settings_version + " GET : 406")
    public void testComissions406() {
        given().header("User-Agent", "Crypterium/1.6.5 (Android; 26): samsung SM-A530F")
                .expect().statusCode(406).when()
                .get(EndPoints.ex_settings_version);
    }
}
