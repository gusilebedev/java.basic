public class Computer {
    private final String name;
    private final String vendor;

    private Processor processor;
    private RAM ram;
    private Memory memory;
    private Display display;
    private Кeyboard keyboard;

    public int computerMass = 0;

    public Computer(String name, String vendor, Processor processor, RAM ram, Memory memory, Display display, Кeyboard keyboard) {
        this.name = name;
        this.vendor = vendor;
        this.processor = processor;
        this.ram = ram;
        this.memory = memory;
        this.display = display;
        this.keyboard = keyboard;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public RAM getRam() {
        return ram;
    }

    public Memory getMemory() {
        return memory;
    }

    public Display getDisplay() {
        return display;
    }

    public Кeyboard getKeyboard() {
        return keyboard;
    }
    public int getComputerMass() {
        computerMass = computerMass + processor.getProcessorMass()
                + ram.getRamMass() + memory.getMemoryMass()
                + display.getDisplayMass() + keyboard.getKeyboardMass();
        return computerMass;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setKeyboard(Кeyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void setComputerMass(int computerMass) {
        this.computerMass = computerMass;
    }

    public String toString() {
        return "Компьютер: " + name + "\n"
                + "Модель: " + vendor + "\n"
                + "Процессор: " + processor + "\n"
                + "ОЗУ: " + ram + "\n"
                + "Внутренний накопитель: " + memory + "\n"
                + "Дисплей: " + display + "\n"
                + "Клавиатора: " + keyboard;
    }
}

