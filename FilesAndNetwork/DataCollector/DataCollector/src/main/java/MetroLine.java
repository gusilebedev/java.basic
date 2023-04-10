public class MetroLine {
    private String lineName;
    private String lineNumber;

    public MetroLine(String lineName, String lineNumber) {
        this.lineName = lineName;
        this.lineNumber = lineNumber;
    }

    public String getLineName() {
        return lineName;
    }
    public String getLineNumber() {
        return lineNumber;
    }

    public String toString() {
        return "Линия метро " + '"' + lineName + '"' + " - " +
                "линия номер " + '"' + lineNumber + '"';
    }
}

