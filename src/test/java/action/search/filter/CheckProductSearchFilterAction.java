package action.search.filter;

import action.abstraction.Action;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor
public class CheckProductSearchFilterAction implements Action {

    @NonNull
    private final Action concreteFilterCheckAction;

    @Override
    public Boolean perform() {
        concreteFilterCheckAction.perform();
        return true;
    }

}
