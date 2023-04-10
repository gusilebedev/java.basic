public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor(3600,6, "Intel", 1 );
        RAM ram = new RAM(RamType.DRAM, 2,2);
        Memory memory = new Memory(MemoryType.SSD,128,3);
        Display display = new Display(24,DisplayType.IPS, 10);
        �eyboard keyboard = new �eyboard(KeyboardType.����������, LightType.����, 3);
        Computer computer = new Computer("Sony", "Vaio", processor, ram, memory,display ,keyboard);

        computer.setDisplay(new Display(19,DisplayType.TN, 8));
        computer.setMemory(new Memory(MemoryType.HDD,512,5));

        System.out.println(computer);
        System.out.println();
        System.out.println("����� ����������: " + computer.getComputerMass() + " ��.");
        System.out.println();


        Processor processor1 = new Processor(3200,4, "AMD", 3 );
        RAM ram1 = new RAM(RamType.SRAM, 1,1);
        Memory memory1 = new Memory(MemoryType.SSD,256,4);
        Display display1 = new Display(21,DisplayType.IPS, 7);
        �eyboard keyboard1 = new �eyboard(KeyboardType.������������, LightType.���, 3);
        Computer computer1 = new Computer("Acer", "Space", processor1, ram1, memory1,display1 ,keyboard1);

        computer1.setProcessor(new Processor(3000,6,"Intel", 4));
        computer1.setRam(new RAM(RamType.DRAM,3,2));

        System.out.println(computer1);
        System.out.println();
        System.out.println("����� ����������: " + computer1.getComputerMass() + " ��.");
    }
    }
//        ������� � 1
//    public static void main(String[] args) {
//        Basket basket = new Basket();
//        basket.add("������", 60,5, 1 );
//        basket.add("����" , 30,3,0.5);
//        basket.add("����", 45,2,2);
//
//        basket.print("���� �������:");
//
//        Basket basket1 = new Basket();
//        basket1.add("������", 60,9,1 );
//        basket1.add("����" , 30,5, 0.5);
//        basket1.add("����", 45,9,2);
//
//        basket1.print("���� �������:");
//
//        Basket basket2 = new Basket();
//        basket2.add("������", 60,5,1 );
//        basket2.add("����" , 30,5, 0.5);
//        basket2.add("����", 45,2,2);
//
//        basket2.print("���� �������:");
//
//        System.out.println("��������� ���� ������: " + Basket.getTotalPrice());
//        System.out.println("���������� ���� �������: " + Basket.getTotalCount());
//        System.out.println("������� ��������� ������: " + Basket.getAveragePrice());
//        System.out.println("������� ��������� �������: " + Basket.getAveragePriceBasket()); }

