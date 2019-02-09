package uml.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DeveloperSearchAction implements Action {

    private final TestContext context;
    private final SimpleAction simpleAction;
    private final Developer developer;

    public static DeveloperSearchAction create(@Nonnull final TestContext context,
                                               @Nonnull final SimpleAction simpleAction,
                                               @Nonnull final Developer developer) {
        return new DeveloperSearchAction(context, simpleAction, developer);
    }

    @Override
    public Boolean perform() {
        processSearchPage(DeveloperSearchPage.create(context));
        return true;
    }

    private void processSearchPage(@Nonnull final DeveloperSearchPage page) {
        simpleAction.clearInputAndSendKeys(page.getNameField(), developer.getName());
        simpleAction.clearInputAndSendKeys(page.getAgeField(), String.valueOf(developer.getAge()));
        simpleAction.selectDropDownByText(page.getCountrySelect(), developer.getCountry());
        simpleAction.clickAndWaitForLoading(page.getSaveButton());
    }

}








