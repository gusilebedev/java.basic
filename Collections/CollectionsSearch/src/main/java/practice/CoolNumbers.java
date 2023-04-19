package practice;

import java.text.DecimalFormat;
import java.util.*;

public class CoolNumbers {

    public static List<String> generateCoolNumbers() {
        ArrayList<String> numbersAuto = new ArrayList<>();
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
            numbersAuto.add(number);
        }
        return numbersAuto;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        if (list.contains(number)) {
            return true;
        }
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int index = Collections.binarySearch(sortedList, number);
        if (index >= 0) {
            return true;
        }
        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        if (hashSet.contains(number)) {
            return true;
        }
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        if (treeSet.contains(number)) {
            return true;
        }
        return false;
    }
}
