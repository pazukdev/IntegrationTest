package uml.core;

import org.junit.Test;

/**
 * @author Siarhei Sviarkaltsau
 */
public class DeveloperSearchRightIT extends AbstractIT {

    private String skill;
    private String country;
    private Integer age;

    private User user;
    private Developer expectedDeveloper;

    private LoginAction loginAction;
    private DeveloperSearchAction developerSearchAction;
    private DeveloperSearchAsserter asserter;

    @Test
    public void searchForDeveloper() {
        skill = "python";
        country = "India";
        age = 50;

        initLocalTestContext();

        loginAction.perform();
        developerSearchAction.perform();
        asserter.perform();
    }

    private void initLocalTestContext() {
        initEntities();
        initActions();
    }

    private void initEntities() {
        user = User.createDefault();
        expectedDeveloper = Developer.create(skill, country, age);
    }

    private void initActions() {
        loginAction = LoginAction.create(context, simpleAction, user);
        developerSearchAction = DeveloperSearchAction.create(context, simpleAction, expectedDeveloper);
        asserter = DeveloperSearchAsserter.create(context, expectedDeveloper);
    }

}
