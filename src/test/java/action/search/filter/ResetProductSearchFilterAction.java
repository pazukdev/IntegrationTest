package action.search.filter;

import action.abstraction.Action;
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
public class ResetProductSearchFilterAction<T extends FilterApplier> implements Action {

    @NonNull
    private final WebDriver driver;
    @NonNull
    private final Class<T> applierType;
    @NonNull
    private final SearchFilter filter;

    @Override
    public Boolean perform() {
        getFilterApplier().resetFilter();
        return true;
    }

    private FilterApplier getFilterApplier() {
        final FilterApplier filterApplier = PageFactory.initElements(driver, applierType);
        filterApplier.setFilter(filter);
        return filterApplier;
    }

}
