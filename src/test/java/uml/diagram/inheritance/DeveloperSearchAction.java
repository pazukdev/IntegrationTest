package uml.diagram.inheritance;

import uml.core.Developer;
import uml.core.DeveloperSearchPage;
import uml.core.TestContext;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
public class DeveloperSearchAction extends AbstractAction {

    private final Developer developer;

    private DeveloperSearchAction(final TestContext context,
                                  final Developer developer) {
        super(context);
        this.developer = developer;
    }

    public static DeveloperSearchAction create(@Nonnull final TestContext context,
                                               @Nonnull final Developer developer) {
        return new DeveloperSearchAction(context, developer);
    }

    @Override
    public Boolean perform() {
        processSearchPage(DeveloperSearchPage.create(context));
        return true;
    }

    private void processSearchPage(@Nonnull final DeveloperSearchPage page) {
        clearInputAndSendKeys(page.getNameField(), developer.getSkill());
        clearInputAndSendKeys(page.getAgeField(), String.valueOf(developer.getAge()));
        selectDropDownByText(page.getCountrySelect(), developer.getCountry());
        clickAndWaitForLoading(page.getSaveButton());
    }

}








