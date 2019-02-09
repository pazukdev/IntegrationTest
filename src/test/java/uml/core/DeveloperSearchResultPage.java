package uml.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DeveloperSearchResultPage {

    @FindBy(xpath = "reservation")
    private WebElement searchResultData;

    private final TestContext context;

    public static DeveloperSearchResultPage create(@Nonnull final TestContext context) {
        final DeveloperSearchResultPage page = new DeveloperSearchResultPage(context);
        PageFactory.initElements(context.getDriver(), page);
        return page;
    }

}
