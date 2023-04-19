package practice;

import java.util.Scanner;

public class TrucksAndContainers {

    private static final int BOXES_IN_CONTAINER = 27;
    private static final int CONTAINER_IN_TRUCK = 12;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя

        int boxes = scanner.nextInt();
        int truck = 0;
        int container = 0;

        if(boxes <= 0) {
        } else {
            System.out.println( "Грузовик: " + ++truck + System.lineSeparator() +
                    "\tКонтейнер: " + ++container);
        }
        for (int i = 1; i <= boxes; i++) {
            System.out.println("\t\tЯщик: " + i);
            if (boxes <= 0) {
                break;
            } else if (i % (BOXES_IN_CONTAINER * CONTAINER_IN_TRUCK) == 0) {
                if (boxes != BOXES_IN_CONTAINER * CONTAINER_IN_TRUCK) {
                    truck++;
                    container++;
                    System.out.println("Грузовик: " + truck + System.lineSeparator() +
                            "\tКонтейнер: " + container);
                }
            } else if (i % BOXES_IN_CONTAINER == 0) {
                if (i != boxes) {
                    container++;
                    System.out.println("\tКонтейнер: " + container);
                }
            }
        }
        System.out.println("Необходимо:" + System.lineSeparator() +
                "грузовиков - " + truck + " шт." + System.lineSeparator() +
                "контейнеров - " + container + " шт.");
    }
}
// TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
// пример вывода при вводе 2
// для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
`               Ящик: 2
        Необходимо:
        грузовиков - 1 шт.`
        контейнеров - 1 шт.
        */