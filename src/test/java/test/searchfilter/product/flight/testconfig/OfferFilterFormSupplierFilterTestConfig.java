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
public class OfferFilterFormSupplierFilterTestConfig extends AbstractFlightSearchFilterTestConfig {

    @Override
    protected String getTestingFeature() {
        return "OfferFilterFormSupplierFilter";
    }

    @Override
    protected SearchFilter getFilter() {
        return new SupplierFilter(ExternalSupplier.AMADEUS);
    }

    @Override
    protected Class getApplierType() {
        return FlightOfferFilterForm.class;
    }

    @Override
    protected Action getConcreteFilterCheckAction(final SearchFilter filter) {
        return new SupplierFilterCheckAction((SupplierFilter) filter, driver);
    }

}
