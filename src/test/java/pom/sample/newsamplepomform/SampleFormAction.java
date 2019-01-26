package pom.sample.newsamplepomform;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import testcore.AbstractWebDriverAware;

/**
 * Actually now this is the same as OldSamplePOMForm - Page Object of Sample Form. But with UI elements separated from
 * methods.
 *
 * @author Siarhei Sviarkaltsau
 */
public class SampleFormAction extends AbstractWebDriverAware {

    private final SampleForm form; // link to UI elements container


    public SampleFormAction(final WebDriver driver) {
        super(driver);
        form = PageFactory.initElements(driver, SampleForm.class);
    }

    public void saveForm() {
        clickAndWaitForLoading(form.getSaveButton());
    }

    public void closeForm() {
        clickAndWaitForLoading(form.getCloseButton());
    }

    public void saveAndCloseForm() {
        clickAndWaitForLoading(form.getSaveButton());
        clickAndWaitForLoading(form.getCloseButton());
    }

    public void openAdditionalOptions() {
        clickAndWaitForLoading(form.getAdditionalOptionsSpoiler());
        try {
            form.getReservationSystemSelect().isDisplayed(); // check if spoiler opened via check if element under spoiler is displayed
        } catch (final NoSuchElementException e) {
            clickAndWaitForLoading(form.getAdditionalOptionsSpoiler());
        }
    }

    public void setFlightType(final CharterType type) {
        switch (type) {
            case ROUND_TRIP:
                clickAndWaitForLoading(form.getRoundTripRadiobutton());
                break;
            case ONE_WAY:
                clickAndWaitForLoading(form.getOneWayRadiobutton());
                break;
            case MULTI_CITY:
                clickAndWaitForLoading(form.getMultiCityRadiobutton());
        }
    }

    public void setDates(final String dateFrom, final String dateTo) {
        clearInputAndSendKeys(form.getDateFromField(), dateFrom);
        clearInputAndSendKeys(form.getDateToField(), dateTo);
    }

}
