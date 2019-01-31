package testcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
public class WebDriverFactory {

    protected static final String CHROME_PLUGIN_PATH = System.getProperties().getProperty("CHROME_PLUGIN_PATH");
    private static final String SELENIUM_GRID_URL = System.getProperties().getProperty("seleniumGridUrl", "sampleURL");
    private WebDriver driver;

    @Bean
    public WebDriver getDriver() throws Exception {
        if (driver != null) return driver;
        else {
            borrowWebDriver();
            return driver;
        }
    }

    private void borrowWebDriver() throws Exception {
        if (ScreenshotTestRule.specificWebDriver.get() != null) {
            this.driver = ScreenshotTestRule.specificWebDriver.get().newInstance();

        } else {
            final SpecificDriver findAnnotation = AnnotationUtils.findAnnotation(this.getClass(), SpecificDriver.class);
            if (findAnnotation != null) {
                final Class<? extends WebDriver> spDriverClass = findAnnotation.value();
                this.driver = spDriverClass.newInstance();

            } else {
                this.driver = createDriver();
            }
        }
        driver.manage().window().maximize();
    }

    private WebDriver createDriver() throws MalformedURLException {
        return createCustomDriver(true);
    }

    private WebDriver createCustomDriver(final boolean isHeadless) throws MalformedURLException {
        final DesiredCapabilities capability = DesiredCapabilities.chrome();
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920,1080", "disable-dev-tools");
        capability.setCapability(ChromeOptions.CAPABILITY, options);

        final RemoteWebDriver res;
        if (System.getProperty("phantomDriver", "false").equals("false")) {

            if (StringUtils.isNotEmpty(CHROME_PLUGIN_PATH)) {
                options.addExtensions(new File(CHROME_PLUGIN_PATH));
            }

            res = new ChromeDriver(options);
        } else {
            if (isHeadless) {
                options.addArguments("headless", "disable-gpu");
            } else {
                options.addArguments("disable-dev-shm-usage");
            }

            res = new RemoteWebDriver(new URL(SELENIUM_GRID_URL), options);
            res.setFileDetector(new LocalFileDetector());
        }
        return res;
    }

}
