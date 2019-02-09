package uml.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Wladimir Litvinov
 */
public interface TestContext {

    Config getConfig();

    WebDriver getDriver();

    String getUniqueLabel();

    JavascriptExecutor getJavascriptExecutor();

    WebDriverWait getWaitForElement();

    FlowPath getFlowPathFormer();

}
