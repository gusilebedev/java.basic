package practice;

import java.util.*;

/* За ключ я выбрал имя, а за значение телефон. Поиск в телефонной книге в основном
 происходит по имени, в моей программе имя - это ключ. Поиск будет занимать меньшее количество
 времени, чем в случае если бы ключом был телефон. */

public class Main {

    private final static String LIST = "LIST";
    public static final String ERROR = "Неверный формат ввода";
    public static final String OK = "Контакт сохранен!";

    public static final String PHONE_VERIFICATION = "^[7][9][0-9]{2}[0-9]{3}[0-9]{4}$";
    public static final String NAME_VERIFICATION = "^[a-zA-Zа-яА-Я' ']{1,20}$";

    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            String scanner = new Scanner(System.in).nextLine();

            if (scanner.contains(LIST)) {
                printMap(phoneBook);
                continue;
            }
            if (scanner.matches(NAME_VERIFICATION)) {
                if (phoneBook.containsKey(scanner)) {
                    System.out.println("Такое имя в телефонной книге есть.");
                    getKeyByValue(phoneBook, scanner);
                } else {
                    System.out.println("Такого имени в телефонной книге нет.\n" +
                            "Введите номер телефона для абонента" + " - " + scanner);
                    String phone = new Scanner(System.in).nextLine();
                    if (phone.matches(PHONE_VERIFICATION)) {
                        if (phoneBook.containsValue(phone)) {
                            removeKey(phoneBook, phone);
                            phoneBook.put(scanner, phone);
                            System.out.println(OK);
                        } else {
                            phoneBook.put(scanner, phone);
                            System.out.println(OK);
                        }
                    } else {
                        System.out.println(ERROR);
                    }
                }
                continue;
            }
            if (scanner.matches(PHONE_VERIFICATION)) {
                if (phoneBook.containsValue(scanner)) {
                    System.out.println("Такой номер в телефонной книге есть.");
                    getKeyByValue(phoneBook, scanner);
                } else {
                    System.out.println("Такого номера в телефонной книге нет.\n" +
                            "Введите имя абонента для номера" + " - " + scanner);
                    String name = new Scanner(System.in).nextLine();
                    if (name.matches(NAME_VERIFICATION)) {
                        if (phoneBook.containsKey(name)) {
                            String numbers = phoneBook.get(name) + ", " + scanner;
                            phoneBook.put(name, numbers);
                            System.out.println(OK);
                        } else {
                            phoneBook.put(name, scanner);
                            System.out.println(OK);
                        }
                    } else {
                        System.out.println(ERROR);
                    }
                }
                continue;
            } else {
                System.out.println(ERROR);
            }
        }
    }

    public static void printMap(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }
    }

    public static void getKeyByValue(Map<String, String> map, String scanner) {
        for (Map.Entry entry : map.entrySet()) {
            if (Objects.equals(scanner, entry.getValue())) {
                System.out.println(entry.getKey() + " - " + scanner);
            }
            if (Objects.equals(scanner, entry.getKey())) {
                System.out.println(scanner + " - " + entry.getValue());
            }
        }
    }

    public static void removeKey(Map<String, String> map, String phone) {
        for (Map.Entry entry : map.entrySet()) {
            if (Objects.equals(phone, entry.getValue())) {
                map.remove(entry.getKey());
            }
        }
    }
}
