package practice;

import java.util.*;

public class EmailList {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static final String EMAIL_VERIFICATION = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    Set<String> treeSet = new TreeSet<>();
    public void add(String email) {
        if (email.matches(EMAIL_VERIFICATION)) {
            treeSet.add(email.toLowerCase());
        } else {
            System.out.println(WRONG_EMAIL_ANSWER);
        }
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
    }
    public List <String> getSortedEmails() {
        ArrayList<String> sortedEmails = new ArrayList<String>();
        sortedEmails.addAll(treeSet);
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        return sortedEmails;
    }
}
