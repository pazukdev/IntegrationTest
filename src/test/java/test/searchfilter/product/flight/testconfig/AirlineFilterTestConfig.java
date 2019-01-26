package test.searchfilter.product.flight.testconfig;

import action.abstraction.Action;
import entity.filter.SearchFilter;
import entity.filter.flight.AirlineFilter;
import org.springframework.context.annotation.Configuration;
import test.searchfilter.product.flight.testconfig.abstraction.AbstractFlightSearchFilterTestConfig;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
public class AirlineFilterTestConfig extends AbstractFlightSearchFilterTestConfig {

    @Override
    protected String getTestingFeature() {
        return "SearchFormAirlineFilter";
    }

    @Override
    protected SearchFilter getFilter() {
        return new AirlineFilter(new Airline(Airline.AirlineCode.KL));
    }

    @Override
    protected Class getApplierType() {
        return FlightSearchForm.class;
    }

    @Override
    protected Action getConcreteFilterCheckAction(final SearchFilter filter) {
        return new AirlineFilterCheckAction((AirlineFilter) filter, driver);
    }

}













