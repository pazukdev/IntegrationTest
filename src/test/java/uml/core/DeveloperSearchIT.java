package uml.core;

import org.junit.Test;

/**
 * @author Siarhei Sviarkaltsau
 */
public class DeveloperSearchIT extends AbstractIT{

    @Test
    public void searchForDeveloper() {
        final String skill = "python";
        final String country = "India";
        final Integer age = 50;

        final User user = User.createDefault();
        LoginAction.create(context, simpleAction, user).perform();
        final Developer expectedDeveloper = Developer.create(skill, country, age);
        DeveloperSearchAction.create(context, simpleAction, expectedDeveloper).perform();
        DeveloperSearchAsserter.create(context, expectedDeveloper).perform();
    }

}




