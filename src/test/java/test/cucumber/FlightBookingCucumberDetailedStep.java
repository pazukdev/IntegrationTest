package test.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Siarhei Sviarkaltsau
 */
public class FlightBookingCucumberDetailedStep {

    // precondition steps

    @Given("^Supplier is created$")
    public void performPrecondition() {
        // write me
    }

    // condition steps

    @When("^TO1 user login$")
    public void login() {
        // write me
    }

    @When("^sets markup ([^\"]*)$")
    public void setMarkup(final String markup) {
        // write me
    }

    @When("^creates charter ([^\"]*): ([^\"]*) currency, ([^\"]*) airline, ([^\"]*) pick up, ([^\"]*) drop off points$")
    public void createCharter(final String... charterConfig) {
        // write me
    }

    @When("^creates flight ([^\"]*): ([^\"]*) class, ([^\"]*) direction$")
    public void createFlight(final String flightName, final String flightClass, final String direction) {
        // write me
    }

    @When("^if ([^\"]*) is ([^\"]*) creates return flight ([^\"]*): ([^\"]*) class, ([^\"]*) direction$")
    public void createReturnFlight(final String actualCharterType,
                                   final String expectedCharterType,
                                   final String flightName,
                                   final String flightClass,
                                   final String direction) {
        if (actualCharterType.equals(expectedCharterType)) {
            createFlight(flightName, flightClass, direction);
        }
    }

    @When("^creates trip: ([^\"]*), departure ([^\"]*), return ([^\"]*), duration ([^\"]*)$")
    public void createTrip(final int flightNumber,
                           final String departureTime,
                           final String returnTime,
                           final String duration) {
        // write me
    }

    @When("^if ([^\"]*) is ([^\"]*) creates trip: ([^\"]*), departure ([^\"]*), return ([^\"]*), duration ([^\"]*)$")
    public void createReturnTrip(final String actualCharterType,
                                 final String expectedCharterType,
                                 final int flightNumber,
                                 final String departureTime,
                                 final String returnTime,
                                 final String duration) {
        if (actualCharterType.equals(expectedCharterType)) {
            createTrip(flightNumber, departureTime, returnTime, duration);
        }
    }

    @When("^selects ([^\"]*), sets ([^\"]*) quantity ([^\"]*), clicks Update$")
    public void setTripAvailability(final String flightName, final String quantityType, final int quantity) {
        // write me
    }

    @When("^if ([^\"]*) is ([^\"]*) selects ([^\"]*), sets ([^\"]*) quantity (\\d+), clicks Update$")
    public void setReturnTripAvailability(final String actualCharterType,
                                          final String expectedCharterType,
                                          final String flightName,
                                          final String quantityType,
                                          final int quantity) {
        if (actualCharterType.equals(expectedCharterType)) {
            setTripAvailability(flightName, quantityType, quantity);
        }
    }

    @When("^creates price list: ([^\"]*), prices: (\\d+) adult, (\\d+) child, (\\d+) infant$")
    public void createPriceList(final String actualCharterType,
                                final int adultPrice,
                                final int childPrice,
                                final int infantPrice) {
        // write me
    }

    @When("^if ([^\"]*) is ([^\"]*) creates price list: ([^\"]*), prices: (\\d+) adult, (\\d+) child, (\\d+) infant$")
    public void createRoundTripPriceList(final String actualCharterType,
                                         final String expectedCharterType,
                                         final int adultPrice,
                                         final int childPrice,
                                         final int infantPrice) {
        if (actualCharterType.equals(expectedCharterType)) {
            createPriceList(actualCharterType, adultPrice, childPrice, infantPrice);
        }
    }

    @When("^creates tariff$")
    public void createTariff() {
        // write me
    }

    @When("^creates discount ([^\"]*)$")
    public void createDiscount(final String discount) {
        // write me
    }

    @When("^creates penalty ([^\"]*)$")
    public void createPenalty(final String penalty) {
        // write me
    }

    @Then("^he should see created flight with correct data: ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*) status$")
    public void checkCreatedFlightData(final String flightName,
                                       final String supplierName,
                                       final String departureAirportCode,
                                       final String arrivalAirportCode,
                                       final String status) {
        // write me
    }

    @When("^inputs correct search data: ([^\"]*), from ([^\"]*), to ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*)$")
    public void processFlightSearchForm(final String... searchData) {
        // write me
    }

    @When("^The user clicks Book, inputs data of all passengers into form and clicks Continue$")
    public void inputPassengersData() {
        // write me
    }

    @When("^clicks \"Cash payment\", accepts Fare conditions, clicks Book$")
    public void acceptFareConditions() {
        // write me
    }

    @When("^([^\"]*) is ([^\"]*) user clicks Cancel and accepts cancellation$")
    public void cancelReservation(final String actualFeature, final String expectedFeature) {
        // write me
    }

    @When("^([^\"]*) is ([^\"]*) user clicks \"Book it again\" and clicks \"Create a new order\"$")
    public void rebookWithNewOrder(final String actualFeature, final String expectedFeature) {
        // write me
    }

    @When("^([^\"]*) is ([^\"]*) user clicks \"Book it again\" and clicks \"Add to the current order\"$")
    public void rebookWithCurrentOrder(final String actualFeature, final String expectedFeature) {
        // write me
    }

    @When("^the user has ([^\"]*) in his mind, he clicks Book it again$")
    public void clickBookItAgain(final String rebooking) {
        // write me
    }

    @When("^checks availability$")
    public void checkAvailability(final String rebookingType) {
        // write me
    }

    @When("^([^\"]*) is ([^\"]*) user goes to the charter -> Prices -> Tags spoiler and creates PRIVATE tag$")
    public void createTag(final String actualFeature, final String expectedFeature) {
        // write me
    }

    @When("^specifies PRIVATE tag in \"Products, marked with these tags will NOT be offered via the contract\" field$")
    public void addTagInSalesSettings() {
        // write me
    }

    @When("^([^\"]*) is ([^\"]*) user go to Reservations list, ticks the reservation and changes manager$")
    public void changeManager(final String actualFeature, final String expectedFeature) {
        // write me
    }

    // check steps

    @Then("^he ([^\"]*) find the flight$")
    public void checkFlightSearchResult(final String shouldBeFound) {
        // write me
    }

    @Then("^displayed prices should be correct: ([^\"]*) for supplier, ([^\"]*) for client$")
    public void checkFlightDataAtFlightOfferForm(final String supplierPrice, final String clientPrice) {
        // write me
    }

    @Then("^he should see reservation status ([^\"]*) and prices: ([^\"]*), ([^\"]*)$")
    public void checkBookingData(final String reservationStatus,
                                 final String supplierPrice,
                                 final String clientPrice) {
        // write me
    }

    @Then("^he should see that new manager is displayed in the reservation$")
    public void checkManager() {
        // write me
    }

}
































