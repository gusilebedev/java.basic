public class Memory {
    private final MemoryType memoryType;
    private final int memoryVolyme;
    private final int memoryMass;

    public Memory(MemoryType memoryType, int memoryVolyme, int memoryMass) {
        this.memoryType = memoryType;
        this.memoryVolyme = memoryVolyme;
        this.memoryMass = memoryMass;
    }

    public MemoryType getMemoryType() {
        return memoryType;
    }

    public int getMemoryVolyme() {
        return memoryVolyme;
    }

    public int getMemoryMass() {
        return memoryMass;
    }
    public String toString() {
        return memoryType + " " + memoryVolyme + " รแ.";
    }
}
