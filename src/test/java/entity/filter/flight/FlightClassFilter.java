package entity.filter.flight;

import entity.filter.SearchFilter;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor
@Getter
public class FlightClassFilter implements SearchFilter {

    @NonNull
    private final FlightClass flightClass;


    @Override
    public String toString() {
        return "flight class filter: " + flightClass;
    }

}
