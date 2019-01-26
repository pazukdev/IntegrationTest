package test.searchfilter.product.flight.testconfig.abstraction;

import action.InteractWithFormDefaultWayAction;
import action.abstraction.Action;
import action.search.filter.factory.ProductSearchFilterActionFactory;
import entity.filter.SearchFilter;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pom.DefaultInteractable;
import scenario.TestSearchFormFilterScenario;
import scenario.abstraction.Scenario;

import javax.inject.Inject;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
@Import({WebDriverFactory.class})
public abstract class AbstractFlightSearchFilterTestConfig {

    @Inject
    protected WebDriver driver;

    @Bean
    protected DefaultInteractable getDefaultInteractable() {
        return new FlightSearchForm(driver);
    }

    @Bean(name = "precondition")
    protected Action getPrecondition() {
        return new InteractWithFormDefaultWayAction();
    }

    @Bean
    protected ProductSearchFilterActionFactory getActionFactory(final Class applierType,
                                                                final SearchFilter filter,
                                                                final Action concreteFilterCheckAction) {
        return new ProductSearchFilterActionFactory(driver, applierType, filter, concreteFilterCheckAction);
    }

    @Bean
    protected Scenario getTestScenario() {
        return new TestSearchFormFilterScenario();
    }

    // abstract methods

    @Bean
    protected abstract String getTestingFeature();

    @Bean
    protected abstract SearchFilter getFilter();

    @Bean
    protected abstract Class getApplierType();

    @Bean(name = "concreteFilterCheckAction")
    protected abstract Action getConcreteFilterCheckAction(final SearchFilter filter);

}















