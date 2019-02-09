package uml.diagram.inheritance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uml.core.TestContext;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Wladimir Litvinov
 */
public abstract class AbstractAction<T> implements Action {

    protected final TestContext context;

    protected AbstractAction(final TestContext context) {
        this.context = context;
    }

    protected WebElement waitForElement(final Supplier<WebElement> supp) {
        return null;
    }

    protected void waitForPageToLoad() {}

    protected void waitForA4JToFinish() {}

    protected <V> void waitOptionalWithTimeout(final Function<? super WebDriver, V> conditionIsTrue,
                                               final int timeoutInSeconds) {}

    protected void selectDropDownByText(final WebElement webElement, final String value) {}

    protected void selectDropDownByValue(final WebElement webElement, final String value) {}

    protected void clearInputAndSendKeys(final WebElement input, final String text) {}

    protected void performJSClick(final WebElement webElement) {}

    protected void setCheckboxSelection(final WebElement checkbox, final boolean value) {}

    protected void clickAndWaitForLoading(final WebElement element) {}

    protected void fillInputOptionally(final Supplier<WebElement> element, final String text) {}

    protected boolean selectDropdownOptionally(final Supplier<WebElement> select, final String text) {
        return true;
    }

}
