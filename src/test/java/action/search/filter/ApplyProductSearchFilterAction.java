package action.search.filter;

import action.abstraction.Action;
import action.abstraction.UndoableAction;
import entity.filter.FilterApplier;
import entity.filter.SearchFilter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor
public class ApplyProductSearchFilterAction<T extends FilterApplier> implements UndoableAction {

    @NonNull
    private final WebDriver driver;
    @NonNull
    private final Class<T> applierType;
    @NonNull
    private final SearchFilter filter;

    @Override
    public void perform() {
        getFilterApplier().applyFilter();
    }

    private FilterApplier getFilterApplier() {
        final FilterApplier filterApplier = PageFactory.initElements(driver, applierType);
        filterApplier.setFilter(filter);
        return filterApplier;
    }

    @Override
    public Action getUndo() {
        return new ResetProductSearchFilterAction(driver, applierType, filter);
    }
}













