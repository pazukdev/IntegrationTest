package testcore;

import action.abstraction.Action;
import lombok.Getter;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;
import java.util.Arrays;

/**
 * @author Siarhei Sviarkaltsau
 */
@Log
public abstract class AbstractUITest extends AbstractWebDriverAware implements Action {

    static {
        LogUtils.setupLogger(log);
    }

    private static final String LOGIN_URL_PATH = "/samplePath";

    @Inject
    private WebDriver driver;
    @Inject
    private String testingFeature;
    @Inject
    private Action[] actions;
    @Getter
    private final OrganizationCreator organizationCreator;
    private final String uniqueLabel;
    private LoginPage loginPage;
    private MainPage mainPage;
    @Rule
    public final ScreenshotTestRule screenshotTestRule;

    public AbstractUITest() {
        super(null);
        screenshotTestRule = new ScreenshotTestRule();
        organizationCreator = new OrganizationCreator();
        uniqueLabel = createUniqueLabel();
    }

    // public methods

    @Before
    public void onStart() {
        setDriver(driver);
        initDriverReqFields(driver);
        createTO1AndLogIntoB2B(createCompanyParams());
        configureFlowCollectorArgumentsCreator();
    }

    @Test
    @Override
    public void perform() {
        performActions(actions);
    }

    // protected methods

    protected void initDriverReqFields(final WebDriver driver) {
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    protected void logIntoB2B(final AuthorizationParameters authorizationParameters) {
        final String url = getConfig().getUrl() + LOGIN_URL_PATH;

        getDriver().get(url);
        login(authorizationParameters);
    }

    protected void login(final AuthorizationParameters authorizationParameters) {
        clearInputAndSendKeys(loginPage.getAliasField(), authorizationParameters.getCompanyCode());
        clearInputAndSendKeys(loginPage.getUsernameField(), authorizationParameters.getLogin());
        clearInputAndSendKeys(loginPage.getPasswordField(), authorizationParameters.getPassword());

        clickAndWaitForLoading(loginPage.getLoginButton());
        // check out whether suspend session button is there
        loginPage.getSuspendSessionButton().ifPresent(this::clickAndWaitForLoading);
    }

    protected void logout() {
        if (getDriver().getWindowHandles().size() > 1) {
            switchToFirstWindow();
        }

        clickAndWaitForLoading(mainPage.getLogoutButton());
    }

    protected String getOperatorName() {
        return OrganizationCreator.getDefaultTo1Name() + " " + uniqueLabel;
    }

    protected void performActions(final Action... actions) {
        Arrays.stream(actions).forEach(Action::perform);
    }

    // abstract methods

    protected abstract CreateCompanyParams createCompanyParams();

    // package-private methods

    void quitSpecificDriver() {
        if (driver != null) {
            this.driver.quit();
        }
    }

    // private methods

    private void createTO1AndLogIntoB2B(final CreateCompanyParams createCompanyParams) {
        // some logic here
    }

    private void log() {
        log.info(flowPathFormer.getFlowReport());
        log.info("Connected reservation systems codes: " + getOrganizationCreator().getSupplierCodes());
    }

    private void configureFlowCollectorArgumentsCreator() {
        // some logic here
    }

    private String createUniqueLabel() {
        final String uniqueLabel = ""; // some logic here
        return uniqueLabel;
    }

}

















