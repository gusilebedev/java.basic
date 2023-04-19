public class RAM {
    private final RamType ramType;
    private final int ramVolume;
    private final int ramMass;

    public RAM(RamType ramType, int ramVolume, int ramMass) {
        this.ramType = ramType;
        this.ramVolume = ramVolume;
        this.ramMass = ramMass;
    }

    public RamType getRamType() {
        return ramType;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public int getRamMass() {
        return ramMass;
    }
    public String toString() {
        return ramType + " " + ramVolume + " รแ.";
    }
}
