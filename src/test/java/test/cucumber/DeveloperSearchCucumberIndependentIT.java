package test.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uml.core.AbstractIT;
import uml.core.Developer;
import uml.core.DeveloperSearchAction;
import uml.core.DeveloperSearchAsserter;
import uml.core.LoginAction;
import uml.core.User;

/**
 * @author Siarhei Sviarkaltsau
 */
public class DeveloperSearchCucumberIndependentIT extends AbstractIT {

    private Developer expectedDeveloper;

    @Given("^User is logged in$")
    public void login() {
        final User user = User.createDefault();
        LoginAction.create(context, simpleAction, user).perform();
    }

    @When("^user searches for developer: (.*), (.*), (.*)$")
    public void searchDeveloper(final String skill, final String country, final Integer age) {
        expectedDeveloper = Developer.create(skill, country, age);
        DeveloperSearchAction.create(context, simpleAction, expectedDeveloper).perform();
    }

    @Then("^he (.*) the developer in search results$")
    public void checkDeveloperSearchResult() {
        DeveloperSearchAsserter.create(context, expectedDeveloper).perform();
    }

}
