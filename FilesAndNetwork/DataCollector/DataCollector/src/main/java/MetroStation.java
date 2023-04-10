public class MetroStation {
    private String stationName;
    private String lineNumber;
    public MetroStation(String stationName, String lineNumber) {
        this.stationName = stationName;
        this.lineNumber = lineNumber;
    }


    public String toString() {
        return "Станция метро " + '"' + stationName + '"' + " - " +
                "номер линии " + '"' + lineNumber + '"';
    }
}

