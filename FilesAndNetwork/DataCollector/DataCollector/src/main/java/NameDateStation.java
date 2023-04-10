public class NameDateStation {
    private String stationName;
    private String stationDate;

    public NameDateStation(String stationName, String stationDate) {
        this.stationName = stationName;
        this.stationDate = stationDate;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStationDate() {
        return stationDate;
    }

    public String toString() {
        return "Станция " + '"'+ stationName + '"' +
                " - " + "дата открытия " + '"'+ stationDate + '"';
    }
}
