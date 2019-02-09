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
public class ContractCreationPage {

    @FindBy(xpath = "contractDataField")
    private WebElement contractDataField;
    @FindBy(xpath = "acceptButton")
    private WebElement acceptButton;

    private final TestContext context;

    public static ContractCreationPage create(@Nonnull final TestContext context) {
        final ContractCreationPage page = new ContractCreationPage(context);
        PageFactory.initElements(context.getDriver(), page);
        return page;
    }

}
