import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class JsonMetro {
    public String date;
    public String depth;
    public String number;
    public String nameLine;

    public static Map<String,String> nameLine2Line = new HashMap<>();
    public static Map<String, List<String>> line2stations = new HashMap<>();
    public void setDate(String date) {
        this.date = date;
    }
    public void setDepth(String depth) {
        this.depth = depth;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }
    public String getNumber() {
        return number;
    }
    public static void jsonFileMetro() {
        JSONObject jsonObjectMetro = new JSONObject();
        JSONObject jsonObjectStation = new JSONObject();
        JSONArray jsonArrayLine = new JSONArray();
        for (String line : line2stations.keySet()) {
            jsonObjectStation.put(line, line2stations.get(line));

        }
        for (MetroLine line : ParseWeb.listLines) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("number",line.getLineNumber());
            jsonObject.put("name",line.getLineName());
            jsonArrayLine.add(jsonObject);
        }
        jsonObjectMetro.put("station", jsonObjectStation);
        jsonObjectMetro.put("lines",jsonArrayLine);

        try (FileWriter file = new FileWriter("data/metro.json")) {
            file.write(jsonObjectMetro.toString());
            file.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void jsonFileStations() {
        Map<String, List<JsonMetro>> metroStation = new HashMap<>();
        JSONArray jsonArrayStations = new JSONArray();
        JSONObject jsonObjectStations = new JSONObject();
        jsonObjectStations.put("stations", jsonArrayStations);

        for (String s2line : ParseWeb.station2Line.keySet()) {
            List<JsonMetro> listStation = new ArrayList<>();
            JSONObject jsonObject = new JSONObject();
            JsonMetro jsonFiles = new JsonMetro();
            jsonFiles.setNumber(ParseWeb.station2Line.get(s2line));
            listStation.add(jsonFiles);
            metroStation.put(s2line, listStation);
            jsonObject.put("name",s2line);
            jsonArrayStations.add(jsonObject);
            for (String nLine2Line : nameLine2Line.keySet()) {
                if (nLine2Line.equals(jsonFiles.getNumber())) {
                    jsonFiles.setNameLine(nameLine2Line.get(nLine2Line));
                    jsonObject.put("line",nameLine2Line.get(nLine2Line));
                }
            }
            for (String s2date : ParseCsv.station2Date.keySet()) {
                for (String s2depth : ParseJson.station2Depth.keySet()) {
                    if (s2date.equals(s2line) && s2depth.equals(s2line)) {
                        jsonFiles.setDate(ParseCsv.station2Date.get(s2date));
                        jsonFiles.setDepth(ParseJson.station2Depth.get(s2depth));
                        jsonObject.put("date",ParseCsv.station2Date.get(s2date));
                        if(!ParseJson.station2Depth.get(s2depth).equals("?")) {
                            jsonObject.put("depth",ParseJson.station2Depth.get(s2depth));
                        }
                    }
                }
            }
        }

        try (FileWriter file = new FileWriter("data/stations.json")) {
            file.write(jsonObjectStations.toString());
            file.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



