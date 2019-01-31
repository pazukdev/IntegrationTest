package action.search.filter.factory;

import action.abstraction.Action;
import action.abstraction.UndoableAction;
import action.search.filter.ApplyProductSearchFilterAction;
import entity.filter.SearchFilter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor
public class ProductSearchFilterActionFactory {

    @NonNull
    private final WebDriver driver;
    @NonNull
    private final Class applierType;
    @NonNull
    private final SearchFilter filter;
    @NonNull
    private final Action checkAction;

    public Action[] createDefaultActionsChain() {
        final UndoableAction applyAction = createApplyAction();
        return new Action[]{applyAction, checkAction, applyAction.getUndo()};
    }

    public UndoableAction createApplyAction() {
        return new ApplyProductSearchFilterAction(driver, applierType, filter);
    }

}













