public class Processor {
    private final int cpu;
    private final int numberOfCores;
    private final String processorVendor;
    private final int processorMass;

    public Processor(int cpu, int numberOfCores, String processorVendor, int processorMass) {
        this.cpu = cpu;
        this.numberOfCores = numberOfCores;
        this.processorVendor = processorVendor;
        this.processorMass = processorMass;
    }

    public int getCpu() {
        return cpu;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getProcessorVendor() {
        return processorVendor;
    }

    public int getProcessorMass() {
        return processorMass;
    }

    public String toString() {
        return  processorVendor + " " + cpu + " √ц." + " " + numberOfCores + " €дерный";
    }
}
