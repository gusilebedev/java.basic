import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParseWeb.printMetro("https://skillbox-java.github.io/");
        FileSearch.fileSearch("data\\");
        ParseJson.printJsonList("data\\station-data\\data\\2\\4\\depths-1.json","data\\station-data\\data\\7\\1\\depths-2.json",
                "data\\station-data\\data\\4\\6\\depths-3.json");
        ParseCsv.printCsvList("data\\station-data\\data\\4\\6\\dates-1.csv","data\\station-data\\data\\0\\5\\dates-2.csv",
                "data\\station-data\\data\\9\\6\\dates-3.csv");
        JsonMetro.jsonFileMetro();
        JsonMetro.jsonFileStations();
    }
}
















