package test.searchfilter.product.flight.testconfig;

import action.abstraction.Action;
import entity.filter.SearchFilter;
import entity.filter.SupplierFilter;
import org.springframework.context.annotation.Configuration;
import test.searchfilter.product.flight.testconfig.abstraction.AbstractFlightSearchFilterTestConfig;

/**
 * @author Siarhei Sviarkaltsau
 */
@Configuration
public class SearchFormSupplierFilterTestConfig extends AbstractFlightSearchFilterTestConfig {

    @Override
    protected String getTestingFeature() {
        return "SearchFormSupplierFilter";
    }

    @Override
    protected SearchFilter getFilter() {
        return new SupplierFilter(ExternalSupplier.AMADEUS);
    }

    @Override
    protected Class getApplierType() {
        return FlightSearchForm.class;
    }

    @Override
    protected Action getFilterCheckAction(final SearchFilter filter) {
        return new SupplierFilterCheckAction((SupplierFilter) filter, driver);
    }

}













