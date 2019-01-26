package pom.sample;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testcore.AbstractWebDriverAware;

/**
 * Page Object of Sample Form according to Selenium definition
 *
 * @author Siarhei Sviarkaltsau
 */

@Getter
public class OldSamplePOMForm extends AbstractWebDriverAware {

    @FindBy(xpath = "//a[contains(@id, 'saveButton')]")
    protected WebElement saveButton;

    @FindBy(xpath = "//a[contains(@id, 'closeButton')]")
    protected WebElement closeButton;

    @FindBy(xpath = "//a[contains(@id, 'additionalOptionsSpoiler')]")
    protected WebElement additionalOptionsSpoiler;

    @FindBy(xpath = "//input[contains(@id, 'reservationSystemSelect')]")
    protected WebElement reservationSystemSelect;

    @FindBy(xpath = "//input[contains(@id, 'dateFromField')]")
    protected WebElement dateFromField;

    @FindBy(xpath = "//input[contains(@id, 'dateToField')]")
    protected WebElement dateToField;

    @FindBy(xpath = "//input[contains(@id, 'roundTripRadiobutton')]")
    protected WebElement roundTripRadiobutton;

    @FindBy(xpath = "//input[contains(@id, 'oneWayRadiobutton')]")
    protected WebElement oneWayRadiobutton;

    @FindBy(xpath = "//input[contains(@id, 'multiCityRadiobutton')]")
    protected WebElement multiCityRadiobutton;


    public OldSamplePOMForm(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void saveForm() {
        clickAndWaitForLoading(saveButton);
    }

    public void closeForm() {
        clickAndWaitForLoading(closeButton);
    }

    public void saveAndCloseForm() {
        clickAndWaitForLoading(saveButton);
        clickAndWaitForLoading(closeButton);
    }

    public void openAdditionalOptions() {
        clickAndWaitForLoading(additionalOptionsSpoiler);
        try {
            reservationSystemSelect.isDisplayed(); // check if spoiler opened via check if element under spoiler is displayed
        } catch (final NoSuchElementException e) {
            clickAndWaitForLoading(additionalOptionsSpoiler);
        }
    }

    public void setFlightType(final CharterType type) {
        switch (type) {
            case ROUND_TRIP:
                clickAndWaitForLoading(roundTripRadiobutton);
                break;
            case ONE_WAY:
                clickAndWaitForLoading(oneWayRadiobutton);
                break;
            case MULTI_CITY:
                clickAndWaitForLoading(multiCityRadiobutton);
        }
    }

    public void setDates(final String dateFrom, final String dateTo) {
        clearInputAndSendKeys(dateFromField, dateFrom);
        clearInputAndSendKeys(dateToField, dateTo);
    }

}
