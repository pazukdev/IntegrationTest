package entity.filter.flight;

import com.sun.jndi.toolkit.dir.SearchFilter;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Siarhei Sviarkaltsau
 */
@RequiredArgsConstructor
@Getter
public class AirlineFilter implements SearchFilter {

    @NonNull
    private final Airline airline;


    @Override
    public String toString() {
        return "airline filter: " + airline.getAirlineCode();
    }

}
