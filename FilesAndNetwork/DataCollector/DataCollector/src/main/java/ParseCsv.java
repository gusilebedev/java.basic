import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ParseCsv {
    public static List<NameDateStation> listStations = new ArrayList<>();
    public static Map<String,String> station2Date = new HashMap<>();
    public static void printCsvList(String path1,String path2,String path3) {
        System.out.println("\nПарсинг файла .csv:");
        parseCsvFile(listStations, path1);
        parseCsvFile(listStations, path2);
        parseCsvFile(listStations, path3);
        for (NameDateStation station : listStations) {
            System.out.println(station);
        }
    }
    private static List<NameDateStation> parseCsvFile(List<NameDateStation> list, String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (int i = 1; i < lines.size(); i++) {
                String[] string = lines.get(i).split(",");
                String name = string[0].replace("ё", "e").toLowerCase().trim();
                String date = string[1].toLowerCase().trim();
                NameDateStation nameDateStation = new NameDateStation(name,date);
                if (station2Date.containsKey(name)) {
                    station2Date.put(name + 2, date);
                } else {
                    station2Date.put(name, date);
                }
                list.add(nameDateStation);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}


