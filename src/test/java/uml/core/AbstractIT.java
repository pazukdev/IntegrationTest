package uml.core;

import org.junit.Before;

/**
 * @author Siarhei Sviarkaltsau
 */
public class AbstractIT {

    protected TestContext context;
    protected SimpleAction simpleAction;

    @Before
    public void onStart() {
        initTestContext();
        simpleAction = SimpleAction.create(context);
    }

    private void initTestContext() {
        context = TestContextImpl.create();
    }

}
