package test.searchfilter.product.flight.testconfig;

import action.abstraction.Action;
import entity.filter.SearchFilter;
import entity.filter.flight.DirectFlightFilter;
import org.springframework.context.annotation.Configuration;
import test.searchfilter.product.flight.testconfig.abstraction.AbstractFlightSearchFilterTestConfig;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
public class DirectFlightFilterTestConfig extends AbstractFlightSearchFilterTestConfig {

    @Override
    protected String getTestingFeature() {
        return "SearchFormDirectFlightFilter";
    }

    @Override
    protected SearchFilter getFilter() {
        return new DirectFlightFilter(true);
    }

    @Override
    protected Class getApplierType() {
        return FlightSearchForm.class;
    }

    @Override
    protected Action getConcreteFilterCheckAction(final SearchFilter filter) {
        return new DirectFlightFilterCheckAction((DirectFlightFilter) filter, driver);
    }
}













