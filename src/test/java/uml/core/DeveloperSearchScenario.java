package uml.core;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
public class DeveloperSearchScenario implements Action {

    private final Action developerSearchAction;
    private final Asserter developerSearchAsserter;

    private DeveloperSearchScenario(final TestContext context,
                                    final SimpleAction simpleAction,
                                    final Developer expectedDeveloper) {

        developerSearchAction = DeveloperSearchAction.create(context, simpleAction, expectedDeveloper);
        developerSearchAsserter = DeveloperSearchAsserter.create(context, expectedDeveloper);
    }

    public DeveloperSearchScenario create(@Nonnull final TestContext context,
                                          @Nonnull final SimpleAction simpleAction,
                                          @Nonnull final Developer developer) {
        return new DeveloperSearchScenario(context, simpleAction, developer);
    }

    @Override
    public Boolean perform() {
        developerSearchAction.perform();
        developerSearchAsserter.perform();
        return true;
    }

}























