package practice;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {

        ArrayList<String> numbersAuto = new ArrayList<>();
        generateNumbers(numbersAuto);
        searchInArrayList(numbersAuto, "Н888ТМ41");
        binarySearchInList(numbersAuto, "Н888ТМ41");
        searchInHashSet(numbersAuto,"Н888ТМ41");
        searchInTreeSet(numbersAuto,"Н888ТМ41");
    }

    public static void generateNumbers(List<String> list) {
        String regex = "[АВЕКМНОРСТУХ][0-9]{3}[АВЕКМНОРСТУХ]{2}[0-9]{2,3}";
        DecimalFormat format1 = new DecimalFormat("000");
        DecimalFormat format2 = new DecimalFormat("00");
        for (int i = 0; i < 2000000; i++) {
            String letter = "АВЕКМНОРСТУХ";
            char X = letter.charAt(new Random().nextInt(letter.length()));
            int N = 111 * (int) Math.round(9 * Math.random());
            char Y = letter.charAt(new Random().nextInt(letter.length()));
            char Z = letter.charAt(new Random().nextInt(letter.length()));
            int R = (int) Math.round(199 * Math.random());
            String number = X + format1.format(N) + Y + Z + format2.format(R);
            list.add(number);
        }
    }

    public static void searchInArrayList(List<String> list, String number) {
        long startTime = System.nanoTime();
        if (list.contains(number)) {
            long endTime = System.nanoTime();
            System.out.println("Номер найден\n" + "Поиск по ArrayList " + (endTime - startTime) + "нс\n");
        } else {
            long endTime = System.nanoTime();
            System.out.println("Номер не найден\n" + "Поиск по ArrayList " + (endTime - startTime) + "нс\n");
        }
    }

    public static void binarySearchInList(List<String> list, String number) {
        Collections.sort(list);
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(list, number);
        long endTime = System.nanoTime();
        if (index >= 0) {
            System.out.println("Номер найден\n" + "Бинарный поиск по ArrayList " + (endTime - startTime) + "нс\n");
        } else {
            System.out.println("Номер не найден\n" + "Бинарный поиск по ArrayList " + (endTime - startTime) + "нс\n");
        }
    }

    public static void searchInHashSet(List<String> list, String number) {
        HashSet<String> numbersAuto = new HashSet<>();
        numbersAuto.addAll(list);
        long startTime = System.nanoTime();
        if (numbersAuto.contains(number)) {
            long endTime = System.nanoTime();
            System.out.println("Номер найден\n" + "Поиск по HashSet " + (endTime - startTime) + "нс\n");
        } else {
            long endTime = System.nanoTime();
            System.out.println("Номер не найден\n" + "Поиск по HashSet " + (endTime - startTime) + "нс\n");
        }
    }
    public static void searchInTreeSet(List<String> list, String number) {
        TreeSet<String> numbersAuto = new TreeSet<>();
        numbersAuto.addAll(list);
        long startTime = System.nanoTime();
        if (numbersAuto.contains(number)) {
            long endTime = System.nanoTime();
            System.out.println("Номер найден\n" + "Поиск по TreeSet " + (endTime - startTime) + "нс\n");
        } else {
            long endTime = System.nanoTime();
            System.out.println("Номер не найден\n" + "Поиск по TreeSet " + (endTime - startTime) + "нс\n");
        }
    }
}





