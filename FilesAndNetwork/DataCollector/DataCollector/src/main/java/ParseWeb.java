import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ParseWeb {

    public static List<MetroLine> listLines = new ArrayList<>();
    public static List<MetroStation> listStations = new ArrayList<>();
    public static Map<String,String> station2Line = new HashMap<>();

    public static void printMetro(String url) throws IOException {
        System.out.println("Парсинг сайта метро:\n");
        Document document = Jsoup.connect(url).get();
        System.out.println("Линии Московского метрополитена:");
        parsMetroLine(document).forEach(System.out::println);
        System.out.println("\n" + "Станции Московского метрополитена:");
        parsMetroStance(document).forEach(System.out::println);
    }
    private static List<MetroLine> parsMetroLine(Document document) {

        Elements elements = document.select("span.js-metro-line");
        for (Element element : elements) {
            String nameLine = element.text().replace("ё", "e").toLowerCase().trim();
            String numberLine = element.attr("data-line").toLowerCase().trim();
            MetroLine metroLine = new MetroLine(nameLine,numberLine);
            JsonMetro.nameLine2Line.put(numberLine,nameLine);

            listLines.add(metroLine);
        }
        return listLines;
    }
    private static List<MetroStation> parsMetroStance(Document document) {

        Elements stationLineList = document.select("div.js-metro-stations");
        for (Element stationElement : stationLineList) {
            List<String> listStation = new ArrayList<>();
            Elements nameElement = stationElement.getElementsByClass("name");
                for (Element nameStation : nameElement) {
                    String name = nameStation.text().replace("ё", "e").toLowerCase().trim();
                    String number =  stationElement.attr("data-line").toLowerCase().trim();
                    MetroStation metroStation = new MetroStation(name, number);
                    JsonMetro.line2stations.put(number,listStation);
                    if(station2Line.containsKey(name)) {
                        station2Line.put(name + 2, number);
                    } else {
                        station2Line.put(name,number);
                    }
                    listStation.add(name);
                    listStations.add(metroStation);
                }
        }
        return listStations;
    }
}