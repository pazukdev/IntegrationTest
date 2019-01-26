package entity.filter;

import com.generation_p.gptour_autotests.b2b.entity.filter.filter.SearchFilter;

/**
 * @author Siarhei Sviarkaltsau
 */
public interface FilterApplier<T extends SearchFilter> {

    void applyFilter();

    void resetFilter();

    void setFilter(SearchFilter filter);

    default String filterToString(final T filter,
                                  final String location,
                                  final String action,
                                  final String logMessageSeparator) {
        return location + " " + action + " " + filter.toString() + logMessageSeparator;
    }

}
