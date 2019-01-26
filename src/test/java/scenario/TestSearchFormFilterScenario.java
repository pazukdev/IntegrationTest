package scenario;

import action.abstraction.Action;
import action.search.filter.factory.ProductSearchFilterActionFactory;
import scenario.abstraction.Scenario;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.Arrays;

/**
 * @author Siarhei Sviarkaltsau
 */
public class TestSearchFormFilterScenario implements Scenario {

    @Resource(name = "precondition")
    private Action precondition;
    @Inject
    private ProductSearchFilterActionFactory actionFactory;

    @Override
    public Boolean perform() {
        performActions(precondition);
        performActions(actionFactory.createDefaultActionsSequence());
        return true;
    }

    private void performActions(final Action... actions) {
        Arrays.stream(actions).forEach(Action::perform);
    }
}
