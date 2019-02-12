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
public class LoginPage {

    @FindBy(xpath = "nameField")
    private WebElement nameField;
    @FindBy(xpath = "passwordField")
    private WebElement passwordField;
    @FindBy(xpath = "loginButton")
    private WebElement loginButton;

    private final TestContext context;

    public static LoginPage create(@Nonnull final TestContext context) {
        final LoginPage page = new LoginPage(context);
        PageFactory.initElements(context.getDriver(), page);
        return page;
    }

}
