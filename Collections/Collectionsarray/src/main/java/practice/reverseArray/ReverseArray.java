package practice.reverseArray;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
        Collections.reverse(Arrays.asList(strings));

        return strings;
        }
    }
