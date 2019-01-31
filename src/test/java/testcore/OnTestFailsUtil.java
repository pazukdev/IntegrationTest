package testcore;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.*;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class contains methods which are used in test rule on test fail
 */
public class OnTestFailsUtil {

    final private static By fatalError = By.xpath("//div[contains(@id, 'errorDisplayContent')]");
    final private static By loadingPopup = By.id("statusDisplay");

    public static void captureScreenshot(final Object o, final String fileName) {
        try {
            final Path path = Paths.get("target", "failsafe-reports", o.getClass().getName());
            path.toFile().mkdirs(); // Insure directory is there
            final Path screenshotPath = path.resolve("screenshot-" + fileName + ".png");
            final FileOutputStream out = new FileOutputStream(screenshotPath.toFile());
            final WebDriver driver = ((AbstractUITest) o).getDriver();
            if (driver == null) {
                System.err.println("Driver is null");
                return;
            }
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
            System.out.println("[[ATTACHMENT|" + screenshotPath.toAbsolutePath().toString() + "]]");
        } catch (final Exception e) {
            e.printStackTrace();
            // No need to crash the tests if the screenshot fails
        }
    }

    public static void checkFatalError(final Throwable t, final Object o) {
        final String errorMessage = "'Fatal Error has occurred' message is displayed on the page.";

        checkUnexpectedElementDisplayed(t, o, fatalError, errorMessage);
    }

    public static void checkPopupLoading(final Throwable t, final Object o) {
        final String errorMessage =
                String.format("Loading popup is displayed on the page. Wait timeout: %d sec.",
                        Config.getInstance().getWaitTimeout());

        checkUnexpectedElementDisplayed(t, o, loadingPopup, errorMessage);
    }

    /**
     * Check for element displayed on page. Used for definitions of common probable test fails causes(
     * fatal error, loading popup).
     *
     * @param t        initial throwable, that caused test to fail
     * @param o        Junit test object {@link ScreenshotTestRule#apply(Statement, FrameworkMethod, Object)}
     * @param selector selector of element to check
     * @param message  error message for Exception, to be thrown on specified element is displayed
     */
    private static void checkUnexpectedElementDisplayed(final Throwable t,
                                                        final Object o,
                                                        final By selector,
                                                        final String message) {
        try {
            final boolean elementDisplays = ((AbstractUITest) o).getDriver()
                    .findElement(selector).isDisplayed();

            if (elementDisplays) {
                throw new RuntimeException(message + "\nCaused by: " + t.getMessage(), t);
            }
        } catch (final NoSuchElementException | NullPointerException e) {
            // pass to rethrow initial failure
        }
    }
}