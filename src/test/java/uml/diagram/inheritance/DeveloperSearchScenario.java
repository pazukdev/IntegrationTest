package uml.diagram.inheritance;

import uml.core.Developer;
import uml.core.TestContext;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
public class DeveloperSearchScenario extends AbstractScenario {

    private final Action developerSearchAction;
    private final Asserter developerSearchAsserter;

    private DeveloperSearchScenario(final TestContext context,
                                    final Developer expectedDeveloper) {
        super(context);
        developerSearchAction = DeveloperSearchAction.create(context, expectedDeveloper);
        developerSearchAsserter = DeveloperSearchAsserter.create(context, expectedDeveloper);
    }

    public DeveloperSearchScenario create(@Nonnull final TestContext context,
                                          @Nonnull final Developer developer) {
        return new DeveloperSearchScenario(context, developer);
    }

    @Override
    public Boolean perform() {
        developerSearchAction.perform();
        developerSearchAsserter.perform();
        return true;
    }

}























