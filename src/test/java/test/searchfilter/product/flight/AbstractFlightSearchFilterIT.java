package test.searchfilter.product.flight;

import common.cucumber.annotation.Cucumberable;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import scenario.abstraction.Scenario;
import test.searchfilter.product.flight.testconfig.AirlineFilterTestConfig;
import test.searchfilter.product.flight.testconfig.DirectFlightFilterTestConfig;
import test.searchfilter.product.flight.testconfig.FlightClassFilterTestConfig;
import test.searchfilter.product.flight.testconfig.OfferFilterFormSupplierFilterTestConfig;
import test.searchfilter.product.flight.testconfig.SearchFormSupplierFilterTestConfig;

import javax.inject.Inject;
import java.util.Set;

/**
 * Flight search entity.filter tests
 *
 * @author Siarhei Sviarkaltsau
 */
@Cucumberable
@Log
public abstract class AbstractFlightSearchFilterIT extends MyAbstractUITest {

    private Set<String> supplierCodesFromProperties;
    @Inject
    private String testingFeature;
    @Inject
    private Scenario testScenario;

    @Override
    public void initDriverReqFields(final WebDriver driver) {
        super.initDriverReqFields(driver);
    }

    @Before
    public void start() {
        supplierCodesFromProperties = getOrganizationCreator().getSupplierCodes();
        flowCollectorArgumentsCreator.configure(supplierCodesFromProperties, testingFeature, HUBProduct.FLIGHT);
    }

    @Test
    public void perform() {
        performActions(testScenario);
    }

    // tests

    // Search flights by one specific supplier
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {OfferFilterFormSupplierFilterTestConfig.class})
    public static class OfferFilterFormSupplierFilterIT extends AbstractFlightSearchFilterIT {}

    // Search flights by one specific supplier
    @ContextConfiguration(classes = {SearchFormSupplierFilterTestConfig.class})
    @RunWith(SpringRunner.class)
    public static class SearchFormSupplierFilterIT extends AbstractFlightSearchFilterIT {}

    // Search flights only direct flight
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {DirectFlightFilterTestConfig.class})
    public static class SearchFormDirectFlightFilterIT extends AbstractFlightSearchFilterIT {}

    // Search flights by class
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {FlightClassFilterTestConfig.class})
    public static class SearchFormFlightClassFilterIT extends AbstractFlightSearchFilterIT {}

    // Search flights by airline
    @RunWith(SpringRunner.class)
    @ContextConfiguration(classes = {AirlineFilterTestConfig.class})
    public static class SearchFormAirlineFilterIT extends AbstractFlightSearchFilterIT {}

}




























