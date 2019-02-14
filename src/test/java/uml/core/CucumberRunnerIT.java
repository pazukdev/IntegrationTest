package uml.core;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Siarhei Sviarkaltsau
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature")
public class CucumberRunnerIT {}

