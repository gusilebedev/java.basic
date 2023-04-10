import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final int TWO_HOURS = 7200000;

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(List::stream)
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE && flight.getDate().getTime() > System.currentTimeMillis()
                        && flight.getDate().getTime() < System.currentTimeMillis() + TWO_HOURS)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        return airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(List::stream)
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE && flight.getDate().getTime() > System.currentTimeMillis()
                        && flight.getDate().getTime() < System.currentTimeMillis() + TWO_HOURS)
                .collect(Collectors.toList());
    }
}
