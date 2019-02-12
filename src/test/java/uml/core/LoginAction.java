package uml.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginAction implements Action {

    private final TestContext context;
    private final SimpleAction action;
    private final User user;

    public static LoginAction create(@Nonnull final TestContext context,
                                     @Nonnull final SimpleAction simpleAction,
                                     @Nonnull final User user) {
        return new LoginAction(context, simpleAction, user);
    }

    @Override
    public Boolean perform() {
        login(user);
        return true;
    }

    private void login(final User user) {
        final LoginPage page = createPage();
        fillPage(page, user);
        acceptPage(page);
    }

    private LoginPage createPage() {
        return LoginPage.create(context);
    }

    private void fillPage(final LoginPage page, final User user) {
        action.clearInputAndSendKeys(page.getNameField(), user.getName());
        action.clearInputAndSendKeys(page.getPasswordField(), user.getPassword());
    }

    private void acceptPage(final LoginPage page) {
        action.clickAndWaitForLoading(page.getLoginButton());
    }

}
