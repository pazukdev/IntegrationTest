package action;

import action.abstraction.Action;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor
public class ProcessFlightSearchFormAction implements Action {

    @NonNull
    private final WebDriver driver;
    @NonNull
    private final Flight flight;
    private FlightSearchForm form;

    @Override
    public void perform() {
        form = new FlightSearchForm(driver);

        goToForm();

        setDepartureAirport();
        setArrivalAirport();
        setAirline();

        acceptFormConfigAndMoveOn();
    }

    // private methods

    private void goToForm() {
        form.goToForm();
    }

    private void setDepartureAirport() {
        if (flight.getDepartureAirportCode() == null) return;
        final String airportCode = flight.getDepartureAirportCode();
        form.setDepartureAirport(airportCode, airportCode);
    }

    private void setArrivalAirport() {
        if (flight.getArrivalAirportCode() == null) return;
        final String airportCode = flight.getArrivalAirportCode();
        form.setArrivalAirport(airportCode, airportCode);
    }

    private void setAirline() {
        if (flight.getAirlineCode() == null) return;
        final String airlineCode = flight.getAirlineCode();
        form.openAdditionalSearchOptions();
        form.setSearchWithAirline(airlineCode, airlineCode);
    }

    private void acceptFormConfigAndMoveOn() {
        form.acceptFormConfigAndMoveOn();
    }

}




















