package tests;

import com.crypterium.cryptApi.utils.EndPoints;
import core.TestScope;
import io.qameta.allure.*;
import org.junit.Test;
import tests.core.ExwalTest;

import static io.restassured.RestAssured.given;

@Epic(TestScope.REGRESS)
@Feature("Api version controller")
public class ApiVersionControllerTests extends ExwalTest {

    @Story("Login from newer app (1.7.0+)")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testComissions() {
        given().header("User-Agent", "Crypterium/1.7.0 (Android; 26): samsung SM-A530F")
                .get(EndPoints.ex_settings_version);
    }

    @Story("Login from older app (1.6.5)")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testComissions406() {
        given().header("User-Agent", "Crypterium/1.6.5 (Android; 26): samsung SM-A530F")
                .expect().statusCode(406).when()
                .get(EndPoints.ex_settings_version);
    }
}
