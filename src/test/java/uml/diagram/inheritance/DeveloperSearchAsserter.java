package uml.diagram.inheritance;

import org.junit.Assert;
import uml.core.Developer;
import uml.core.DeveloperSearchResultPage;
import uml.core.TestContext;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
public class DeveloperSearchAsserter extends AbstractAction implements Asserter {

    private final Developer expectedDeveloper;

    private DeveloperSearchAsserter(final TestContext context,
                                    final Developer expectedDeveloper) {
        super(context);
        this.expectedDeveloper = expectedDeveloper;
    }

    public static DeveloperSearchAsserter create(@Nonnull final TestContext context,
                                                 @Nonnull final Developer expectedDeveloper) {
        return new DeveloperSearchAsserter(context, expectedDeveloper);
    }

    @Override
    public Boolean perform() {
        checkSearchResult();
        return true;
    }

    private void checkSearchResult() {
        final Developer actual = createActualDeveloper();
        Assert.assertEquals("Wrong search result", actual, expectedDeveloper);
    }

    private Developer createActualDeveloper() {
        DeveloperSearchResultPage page = DeveloperSearchResultPage.create(context);
        return Developer.createFromSearchResultPage(page);
    }

}
