package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static String ADD = "ADD";
    private final static String EDIT = "EDIT";
    private final static String DELETE = "DELETE";
    private final static String LIST = "LIST";


    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();

        while (true) {
            System.out.println("Введите команду:");
            String scanner = new Scanner(System.in).nextLine();

            if (scanner.contains(ADD)) {
                int firstSpace = scanner.indexOf(' ');
                String todo = scanner.substring(firstSpace).trim();
                char symbol = todo.charAt(0);
                if (Character.isDigit(symbol)) {
                    String[] words = scanner.split("\\s+");
                    int index = Integer.parseInt(words[1]);
                    String regex = "[^A-z ' ']";
                    todo = scanner.substring(firstSpace).replaceAll(regex, "").trim();
                    if (index < todoList.size()) {
                        todoList.add(index, todo);
                    } else {
                        todoList.add(todo);
                    }
                } else {
                    todoList.add(todo);
                }
            }
            if (scanner.contains(DELETE)) {
                String[] words = scanner.split("\\s+");
                int index = Integer.parseInt(words[1]);
                if (index < todoList.size()) {
                    todoList.remove(index);
                } else {
                    System.out.println("Дело с таким номером не существует");
                }
            }

            if (scanner.contains(EDIT)) {
                String[] words = scanner.split("\\s+");
                int index = Integer.parseInt(words[1]);
                int firstSpace = scanner.indexOf(' ');
                String regex = "[^A-z ' ']";
                String todo = scanner.substring(firstSpace).replaceAll(regex, "").trim();
                if (index < todoList.size()) {
                    todoList.set(index, todo);
                } else {
                    System.out.println("Дело с таким номером не существует");
                }
            }
            if (scanner.contains(LIST)) {
                for (int i = 0; i < todoList.size(); i++) {
                    System.out.println(i + " - " + todoList.get(i));
                }
            } else {
            }
            // TODO: написать консольное приложение для работы со списком дел todoList
        }
    }
}