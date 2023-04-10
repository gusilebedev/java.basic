import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex;

    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");
    Line line3 = new Line(3, "Третья");

    Station station1 = new Station("1.1", line1);
    Station station2 = new Station("1.2", line1);
    Station station3 = new Station("1.3", line1);
    Station station4 = new Station("2.1", line2);
    Station station5 = new Station("2.2", line2);
    Station station6 = new Station("2.3", line2);
    Station station7 = new Station("3.1", line3);
    Station station8 = new Station("3.2", line3);
    Station station9 = new Station("3.3", line3);

    @Override
    public void setUp() throws Exception {
        route = new ArrayList<>();
        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);
        route.add(station7);
        route.add(station8);
        route.add(station9);

    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 22;
        assertEquals(expected,actual);
    }

    @Test
    public void testRouteOnTheLine() {
        RouteCalculator calculator = getRouteCalculator();
        Station from = stationIndex.getStation("1.1");
        Station to = stationIndex.getStation("1.3");
        List <Station> actual = calculator.getShortestRoute(from,to);
        List <Station> expected = Arrays.asList(route.get(0),route.get(1),route.get(2));
        assertEquals(expected,actual);
    }

    @Test
    public void testRouteWithOneConnection() {
        RouteCalculator calculator = getRouteCalculator();
        Station from = stationIndex.getStation("1.1");
        Station to = stationIndex.getStation("2.3");
        List <Station> actual = calculator.getShortestRoute(from,to);
        List <Station> expected = Arrays.asList(route.get(0),route.get(1),route.get(3),route.get(4),route.get(5));
        assertEquals(expected,actual);
    }

    @Test
    public void testRouteWithTwoConnections() {
        RouteCalculator calculator = getRouteCalculator();
        Station from = stationIndex.getStation("1.1");
        Station to = stationIndex.getStation("3.3");
        List <Station> actual = calculator.getShortestRoute(from,to);
        List <Station> expected = Arrays.asList(route.get(0),route.get(1),route.get(3),route.get(4),route.get(5),
                route.get(7),route.get(8));
        assertEquals(expected,actual);
    }
    public  RouteCalculator getRouteCalculator() {
        stationIndex = new StationIndex();

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addStation(station9);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line2.addStation(station4);
        line2.addStation(station5);
        line2.addStation(station6);
        line3.addStation(station7);
        line3.addStation(station8);
        line3.addStation(station9);

        stationIndex.addConnection(new ArrayList<>(Arrays.asList(stationIndex.getStation("1.2")
                , stationIndex.getStation("2.1"))));
        stationIndex.addConnection(new ArrayList<>(Arrays.asList(stationIndex.getStation("2.3")
                , stationIndex.getStation("3.2"))));

        return new RouteCalculator(stationIndex);
    }
}
