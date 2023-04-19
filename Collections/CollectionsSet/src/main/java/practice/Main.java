package practice;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */
    private final static String ADD = "ADD";
    private final static String LIST = "LIST";
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String EMAIL_VERIFICATION = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static void main(String[] args) {

        Set<String> treeSet = new TreeSet<>();

        while (true) {
            System.out.println("Введите команду:");
            String scanner = new Scanner(System.in).nextLine();

            if (scanner.contains(ADD)) {
                int firstSpace = scanner.indexOf(' ');
                String email = scanner.substring(firstSpace).trim();
                if (email.matches(EMAIL_VERIFICATION)) {
                    treeSet.add(email.toLowerCase());
                } else {
                    System.out.println(WRONG_EMAIL_ANSWER);
                }
            }
            if (scanner.contains(LIST)) {
                for(String emails: treeSet) {
                    System.out.println(emails);
                }
            } else {
            }
        }
        //TODO: write code here
    }
}