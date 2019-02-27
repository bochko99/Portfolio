package tests.core;

import com.crypterium.cryptApi.utils.SpecStorage;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;

public class ExwalTest extends BaseTest {


    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.exwal();
       // RestAssured.requestSpecification = SpecStorage.exwalOauth();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }
}
