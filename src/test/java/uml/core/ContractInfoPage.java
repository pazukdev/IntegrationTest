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
public class ContractInfoPage {

    @FindBy(xpath = "reservation")
    private WebElement contractInfo;

    private final TestContext context;

    public static ContractInfoPage create(@Nonnull final TestContext context) {
        final ContractInfoPage page = new ContractInfoPage(context);
        PageFactory.initElements(context.getDriver(), page);
        return page;
    }

}
