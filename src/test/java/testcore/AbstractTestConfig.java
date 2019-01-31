package testcore;

import action.abstraction.Action;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.inject.Inject;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
@Import({WebDriverFactory.class})
public class AbstractTestConfig {

    @Inject
    protected WebDriver driver;

    @Bean
    protected Action[] getActionsChain(final Action... actions) {
        return actions;
    }

}
