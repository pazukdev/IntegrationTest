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
public class DirectFlightFilter implements SearchFilter {

    @NonNull
    private final boolean directFlight;


    @Override
    public String toString() {
        return "direct flight filter: directFlight == " + directFlight;
    }

}
