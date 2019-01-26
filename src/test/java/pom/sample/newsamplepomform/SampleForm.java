package pom.sample.newsamplepomform;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Now just a container for UI elements. No any methods excepting getters.
 * 
 * @author Siarhei Sviarkaltsau
 */
@Getter
public class SampleForm {

    @FindBy(xpath = "//a[contains(@id, 'saveButton')]")
    private WebElement saveButton;

    @FindBy(xpath = "//a[contains(@id, 'closeButton')]")
    private WebElement closeButton;

    @FindBy(xpath = "//a[contains(@id, 'additionalOptionsSpoiler')]")
    private WebElement additionalOptionsSpoiler;

    @FindBy(xpath = "//input[contains(@id, 'reservationSystemSelect')]")
    private WebElement reservationSystemSelect;

    @FindBy(xpath = "//input[contains(@id, 'dateFromField')]")
    private WebElement dateFromField;

    @FindBy(xpath = "//input[contains(@id, 'dateToField')]")
    private WebElement dateToField;

    @FindBy(xpath = "//input[contains(@id, 'roundTripRadiobutton')]")
    private WebElement roundTripRadiobutton;

    @FindBy(xpath = "//input[contains(@id, 'oneWayRadiobutton')]")
    private WebElement oneWayRadiobutton;

    @FindBy(xpath = "//input[contains(@id, 'multiCityRadiobutton')]")
    private WebElement multiCityRadiobutton;
    
}
