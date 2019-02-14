package uml.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DeveloperSearchAsserter implements Asserter {

    private final TestContext context;
    private final Developer expectedDeveloper;

    public static DeveloperSearchAsserter create(@Nonnull final TestContext context,
                                                 @Nonnull final Developer expectedDeveloper) {
        return new DeveloperSearchAsserter(context, expectedDeveloper);
    }

    public static DeveloperSearchAsserter create(@Nonnull final boolean expectedTrue,
                                                 @Nonnull final TestContext context,
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
