package common.cucumber;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.runner.JUnitCore;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor
public class TestClassPerformer {

    @NonNull
    private final ConfigToTestMapper mapper;
    private final JUnitCore junit = new JUnitCore();

    /**
     * method choose test class according to arguments and arguments-to-class map and run it with JUnitCore
     */
    public void perform(final String... args) {
        junit.run(getTestClass(args));
    }

    private Class getTestClass(final String... args) {
        return mapper.createMap().get(mapper.createKey(args));
    }

}
