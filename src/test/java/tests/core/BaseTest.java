package tests.core;

import com.crypterium.cryptApi.utils.Environment;
import core.rules.CredentialsRule;
import core.rules.FinancialAnnotationRule;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;

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
