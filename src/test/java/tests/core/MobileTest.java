package tests.core;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import utils.SpecStorage;

public class MobileTest extends BaseTest {

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

}
