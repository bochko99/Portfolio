package core.rules;

import core.annotations.ScopeTarget;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TargetRule extends TestWatcher {

    private ScopeTarget target;

    /**
     * Invoked when a test is about to start
     *
     * @param description
     */
    @Override
    protected void starting(Description description) {
        super.starting(description);
        this.target = description.getAnnotation(ScopeTarget.class);
    }

    public ScopeTarget getTarget() {
        return target;
    }

    public List<String> getStands() {
        if (target == null) {
            return Collections.emptyList();
        }
        return Stream.of(target.stands()).map(ScopeTarget.Stand::toString).collect(Collectors.toList());
    }
}
