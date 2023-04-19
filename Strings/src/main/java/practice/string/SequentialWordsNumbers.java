package practice.string;

public class SequentialWordsNumbers {

    public static String sequentialWordsNumbers(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        int numSymbol = 0;
        String newText = text + ' ';
        String word = "";

        if (text == word) {
            return word;
        }
        else {
            for (int i = 0; i < newText.length(); i++) {
                if (newText.charAt(i) != ' ') {
                    word = word + newText.charAt(i);
                } else {
                    numSymbol++;
                    stringBuilder.append("(" + numSymbol + ")" + ' ' + word + ' ');
                    word = "";
                }
            }
        }
        return stringBuilder.toString().trim();
    }
}

