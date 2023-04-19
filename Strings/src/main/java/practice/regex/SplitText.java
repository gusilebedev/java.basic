package practice.regex;

public class SplitText {

  public static void main(String[] args) {

  }

  public static String splitTextIntoWords(String text) {
    StringBuilder stringBuilder = new StringBuilder();
    String regex = "[^A-z ' ']";
    String word = "";
    String newText = text.replaceAll(regex, "");
    String[] words = newText.split("\\s+");
    for (int i = 0; i < words.length;i++){
      stringBuilder.append(word + words[i] + "\n");
      word = "";
    }
    return stringBuilder.toString().trim();
  }

    //TODO реализуйте метод
  }
