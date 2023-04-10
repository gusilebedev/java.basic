import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ParseJson {
    public static List<NameDepthStation> listStations = new ArrayList<>();
    public static Map<String,String> station2Depth = new HashMap<>();
    public static void printJsonList(String path1,String path2,String path3) {
        System.out.println("\nПарсинг файла .json:");
        parseJsonFile(listStations,path1);
        parseJsonFile(listStations,path2);
        parseJsonFile(listStations,path3);
        for (NameDepthStation station : listStations) {
            System.out.println(station);
        }
    }
    private static List<NameDepthStation> parseJsonFile (List<NameDepthStation> list,String path) {
        try {
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(path));
            int j = 1;
            for (Object obj: jsonArray) {
                JSONObject jsonObject = (JSONObject) obj;
                String name = ((String) jsonObject.get("station_name")).replace("ё", "e").toLowerCase().trim();
                String depth = ((String) jsonObject.get("depth")).toLowerCase().trim();
                NameDepthStation station = new NameDepthStation(name,depth);
                if (station2Depth.containsKey(name)) {
                    station2Depth.put(name + 2, depth);
                } else {
                    station2Depth.put(name, depth);
                }
                list.add(station);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
