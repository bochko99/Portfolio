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
    private ScopeTarget classTarget;

    /**
     * Invoked when a test is about to start
     *
     * @param description
     */
    @Override
    protected void starting(Description description) {
        super.starting(description);
        this.target = description.getAnnotation(ScopeTarget.class);
        this.classTarget = description.getTestClass().getAnnotation(ScopeTarget.class);

    }

    public ScopeTarget getTarget() {
        return target;
    }

    public ScopeTarget getClassTarget() {
        return classTarget;
    }

    public List<String> getStands() {
        if (target == null) {
            return Collections.emptyList();
        }
        return Stream.of(target.value()).map(ScopeTarget.Stand::toString).collect(Collectors.toList());
    }

    public List<String> getClassStands() {
        if (this.classTarget == null) {
            return Collections.emptyList();
        }
        return Stream.of(classTarget.value()).map(ScopeTarget.Stand::toString).collect(Collectors.toList());
    }
}
