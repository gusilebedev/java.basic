public class Main {

    public static void main(String[] args) {
        Processor processor = new Processor(3600,6, "Intel", 1 );
        RAM ram = new RAM(RamType.DRAM, 2,2);
        Memory memory = new Memory(MemoryType.SSD,128,3);
        Display display = new Display(24,DisplayType.IPS, 10);
        Кeyboard keyboard = new Кeyboard(KeyboardType.мембранная, LightType.есть, 3);
        Computer computer = new Computer("Sony", "Vaio", processor, ram, memory,display ,keyboard);

        computer.setDisplay(new Display(19,DisplayType.TN, 8));
        computer.setMemory(new Memory(MemoryType.HDD,512,5));

        System.out.println(computer);
        System.out.println();
        System.out.println("Масса компьютера: " + computer.getComputerMass() + " кг.");
        System.out.println();


        Processor processor1 = new Processor(3200,4, "AMD", 3 );
        RAM ram1 = new RAM(RamType.SRAM, 1,1);
        Memory memory1 = new Memory(MemoryType.SSD,256,4);
        Display display1 = new Display(21,DisplayType.IPS, 7);
        Кeyboard keyboard1 = new Кeyboard(KeyboardType.механическая, LightType.нет, 3);
        Computer computer1 = new Computer("Acer", "Space", processor1, ram1, memory1,display1 ,keyboard1);

        computer1.setProcessor(new Processor(3000,6,"Intel", 4));
        computer1.setRam(new RAM(RamType.DRAM,3,2));

        System.out.println(computer1);
        System.out.println();
        System.out.println("Масса компьютера: " + computer1.getComputerMass() + " кг.");
    }
    }
//        Задание № 1
//    public static void main(String[] args) {
//        Basket basket = new Basket();
//        basket.add("Молоко", 60,5, 1 );
//        basket.add("Хлеб" , 30,3,0.5);
//        basket.add("Вода", 45,2,2);
//
//        basket.print("Ваша корзина:");
//
//        Basket basket1 = new Basket();
//        basket1.add("Молоко", 60,9,1 );
//        basket1.add("Хлеб" , 30,5, 0.5);
//        basket1.add("Вода", 45,9,2);
//
//        basket1.print("Ваша корзина:");
//
//        Basket basket2 = new Basket();
//        basket2.add("Молоко", 60,5,1 );
//        basket2.add("Хлеб" , 30,5, 0.5);
//        basket2.add("Вода", 45,2,2);
//
//        basket2.print("Ваша корзина:");
//
//        System.out.println("Стоимость всех корзин: " + Basket.getTotalPrice());
//        System.out.println("Количество всех товаров: " + Basket.getTotalCount());
//        System.out.println("Средняя стоимость товара: " + Basket.getAveragePrice());
//        System.out.println("Средняя стоимость корзины: " + Basket.getAveragePriceBasket()); }

