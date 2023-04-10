public class NameDepthStation {
    private String stationName;
    private String stationDepth;

    public NameDepthStation(String stationName, String stationDepth) {
        this.stationName = stationName;
        this.stationDepth = stationDepth;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStationDepth() {
        return stationDepth;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    public void setStationDepth(String stationDepth) {
        this.stationDepth = stationDepth;
    }

    public String toString() {
        return "Станция " + '"'+ stationName + '"' +
                " - " + "глубина " + '"'+ stationDepth + '"';
    }
}
