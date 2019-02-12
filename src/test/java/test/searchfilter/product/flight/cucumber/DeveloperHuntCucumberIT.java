package test.searchfilter.product.flight.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Siarhei Sviarkaltsau
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        tags = {"@HuntDeveloper"}
)
public class DeveloperHuntCucumberIT {}
