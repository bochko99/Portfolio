package tests.core;

import core.rules.CredentialsRule;
import core.rules.FinancialAnnotationRule;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import utils.Environment;

public class BaseTest {

    @Rule
    public FinancialAnnotationRule annotation = new FinancialAnnotationRule();

    @Rule
    public CredentialsRule credentials = new CredentialsRule();

    @Before
    public void checkSkipNeed() {
        Assume.assumeTrue(annotation.getAnnotation() == null
                || "true".equalsIgnoreCase(Environment.FINANCE_OPERATIONS_ALLOWED));
    }
}
