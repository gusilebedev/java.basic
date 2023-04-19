public class Display {
    private final int diagonal;
    private final DisplayType displayType;
    private final int displayMass;

    public Display(int diagonal, DisplayType displayType, int displayMass) {
        this.diagonal = diagonal;
        this.displayType = displayType;
        this.displayMass = displayMass;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public DisplayType getDisplayType() {
        return displayType;
    }

    public int getDisplayMass() {
        return displayMass;
    }

    public String toString() {
        return displayType + " " +  diagonal + " ה‏ילא.";
    }
}
