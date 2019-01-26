package test.searchfilter.product.flight.cucumber;

import common.cucumber.ConfigToTestMapper;
import common.cucumber.JUnitTestClassRunable;
import common.cucumber.TestClassPerformer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The difference of this implementation to usual is that no need to implement all the methods mapped to Cucumber steps.
 * All tests are already developed independent from Cucumber. And we should just choose correct test which is
 * match the case from "Examples" table in .feature file and run it.
 *
 * @author Siarhei Sviarkaltsau
 */
public class FlightSearchCucumberStep implements JUnitTestClassRunable {

    private final boolean fromFile = false;
    private final ConfigToTestMapper mapper = new ConfigToTestMapper(fromFile);
    private final TestClassPerformer testPerformer = new TestClassPerformer(mapper);

    @Given("Flight search form: airports: departure: \"LHR\", arrival: \"FRA\" -> search result is displayed")
    public void performPrecondition() {
        // no need to implement
        // precondition depends on test base config only and is the same for any test-specific config
    }

    @When("User sets the ([^\"]*) on the ([^\"]*)")
    public void setFilterOnTheForm(final String filterName, final String formName) {
        chooseAndPerformTest(formName, filterName);
    }

    @Then("He should see only offers matching the filter")
    public void checkOffersList() {
        // no need to implement
        // check depends on selected test config only
    }

    @Override
    public void chooseAndPerformTest(final String... args) {
        testPerformer.perform(args);
    }

}
















