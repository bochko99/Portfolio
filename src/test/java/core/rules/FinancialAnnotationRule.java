package core.rules;

import core.annotations.Financial;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class FinancialAnnotationRule extends TestWatcher {

    private Financial annotation;

    /**
     * Invoked when a test is about to start
     *
     * @param description
     */
    @Override
    protected void starting(Description description) {
        super.starting(description);
        this.annotation = description.getAnnotation(Financial.class);
    }

    public Financial getAnnotation() {
        return annotation;
    }

}