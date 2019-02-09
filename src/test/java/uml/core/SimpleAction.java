package uml.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Wladimir Litvinov
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleAction {

    private final TestContext context;

    public static SimpleAction create(@Nonnull final TestContext context) {
        return new SimpleAction(context);
    }

    public WebElement waitForElement(final Supplier<WebElement> supp) {
        return null;
    }

    public void waitForPageToLoad() {}

    public void waitForA4JToFinish() {}

    public <V> void waitOptionalWithTimeout(final Function<? super WebDriver, V> condition, final int time) {}

    public void selectDropDownByText(final WebElement webElement, final String value) {}

    public void selectDropDownByValue(final WebElement webElement, final String value) {}

    public void clearInputAndSendKeys(final WebElement input, final String text) {}

    public void performJSClick(final WebElement webElement) {}

    public void setCheckboxSelection(final WebElement checkbox, final boolean value) {}

    public void clickAndWaitForLoading(final WebElement element) {}

    public void fillInputOptionally(final Supplier<WebElement> element, final String text) {}

    public boolean selectDropdownOptionally(final Supplier<WebElement> select, final String text) {
        return true;
    }

}
