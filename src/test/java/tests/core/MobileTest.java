package tests.core;

import com.crypterium.cryptApi.Auth;
import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class MobileTest extends BaseTest {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
        Auth.basic(Auth.AuthType.EXWAL);
    }

}
