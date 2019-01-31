package test.searchfilter.product.flight.testconfig.abstraction;

import action.ProcessFlightSearchFormAction;
import action.abstraction.Action;
import action.search.filter.factory.ProductSearchFilterActionFactory;
import entity.filter.SearchFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import scenario.TestSearchFormFilterScenario;
import scenario.abstraction.Scenario;
import testcore.AbstractTestConfig;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
public abstract class AbstractFlightSearchFilterTestConfig extends AbstractTestConfig {

    @Bean
    protected ProductSearchFilterActionFactory getTestActionsFactory(final Class applierType,
                                                                     final SearchFilter filter) {
        return new ProductSearchFilterActionFactory(driver, applierType, filter, getFilterCheckAction(filter));
    }

    @Bean
    protected Scenario getTestScenario(final ProductSearchFilterActionFactory actionFactory) {
        return new TestSearchFormFilterScenario(getPrecondition(), actionFactory);
    }

    // abstract methods

    @Bean
    protected abstract String getTestingFeature();

    @Bean
    protected abstract SearchFilter getFilter();

    @Bean
    protected abstract Class getApplierType();

    protected abstract Action getFilterCheckAction(final SearchFilter filter);

    // private methods

    private Action getPrecondition() {
        return new ProcessFlightSearchFormAction(driver, FlightFactory.createDefaultFlight());
    }

}















