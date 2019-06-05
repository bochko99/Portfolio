package tests.core;

import com.crypterium.cryptApi.utils.Environment;
import core.extensions.CredentialsExtension;
import core.extensions.FinancialExtension;
import core.extensions.StandExtension;
import core.rules.CredentialsRule;
import core.rules.FinancialAnnotationRule;
import core.rules.TargetRule;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FinancialExtension.class)
@ExtendWith(StandExtension.class)
@ExtendWith(CredentialsExtension.class)
public class BaseTest {

    @Rule
    public TargetRule target = new TargetRule();

    @Rule
    public FinancialAnnotationRule annotation = new FinancialAnnotationRule();

    @Rule
    public CredentialsRule credentials = new CredentialsRule();

    @Before
    public void checkSkipNeed() {
        String errMsg = "Financial operations are not allowed";
        Assume.assumeTrue(errMsg, annotation.getAnnotation() == null
                || "true".equalsIgnoreCase(Environment.FINANCE_OPERATIONS_ALLOWED));
    }

    @Before
    public void checkTarget() {
        String classErrMsg = String.format("Current stand '%s' not in {%s}", Environment.TARGET, String.join(", ", target.getClassStands()));
        Assume.assumeTrue(classErrMsg, target.getClassTarget() == null
                || target.getClassStands().contains(Environment.TARGET));
        String errMsg = String.format("Current stand '%s' not in {%s}", Environment.TARGET, String.join(", ", target.getStands()));
        Assume.assumeTrue(errMsg, target.getTarget() == null
                || target.getStands().contains(Environment.TARGET));
    }
}
