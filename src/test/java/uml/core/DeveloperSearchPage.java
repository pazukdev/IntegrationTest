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
public class DeveloperSearchPage {

    @FindBy(xpath = "nameField")
    private WebElement nameField;
    @FindBy(xpath = "ageField")
    private WebElement ageField;
    @FindBy(xpath = "countrySelect")
    private WebElement countrySelect;
    @FindBy(xpath = "saveButton")
    private WebElement saveButton;

    private final TestContext context;

    public static DeveloperSearchPage create(@Nonnull final TestContext context) {
        final DeveloperSearchPage page = new DeveloperSearchPage(context);
        PageFactory.initElements(context.getDriver(), page);
        return page;
    }

}
