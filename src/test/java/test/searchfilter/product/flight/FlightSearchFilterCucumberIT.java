package test.searchfilter.product.flight;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Siarhei Sviarkaltsau
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        tags = {"@FlightSearchFilter"}
)
public class FlightSearchFilterCucumberIT {}
