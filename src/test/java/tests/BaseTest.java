package tests;

import core.SpecStorage;
import core.rules.CredentialsRule;
import core.rules.FinancialAnnotationRule;
import io.restassured.RestAssured;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import utils.Environment;

public class BaseTest {

    @Rule
    public FinancialAnnotationRule annotation = new FinancialAnnotationRule();

    @Rule
    public CredentialsRule credentials = new CredentialsRule();

    @BeforeClass
    public static void init() {
        RestAssured.requestSpecification = SpecStorage.commonRequestSpec();
        RestAssured.responseSpecification = SpecStorage.commonResponseSpec();
    }

    @Before
    public void checkSkipNeed() {
        Assume.assumeTrue(annotation.getAnnotation() == null
                || "true".equalsIgnoreCase(Environment.FINANCE_OPERATIONS_ALLOWED));
    }

}
