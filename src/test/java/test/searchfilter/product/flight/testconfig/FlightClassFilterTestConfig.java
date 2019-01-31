package test.searchfilter.product.flight.testconfig;

import action.abstraction.Action;
import entity.filter.SearchFilter;
import entity.filter.flight.FlightClassFilter;
import org.springframework.context.annotation.Configuration;
import test.searchfilter.product.flight.testconfig.abstraction.AbstractFlightSearchFilterTestConfig;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
public class FlightClassFilterTestConfig extends AbstractFlightSearchFilterTestConfig {

    @Override
    protected String getTestingFeature() {
        return "SearchFormFlightClassFilter";
    }

    @Override
    protected SearchFilter getFilter() {
        return new FlightClassFilter(FlightClass.PREMIUM_ECONOMY);
    }

    @Override
    protected Class getApplierType() {
        return FlightSearchForm.class;
    }

    @Override
    protected Action getFilterCheckAction(final SearchFilter filter) {
        return new FlightClassFilterCheckAction((FlightClassFilter) filter, driver);
    }

}
