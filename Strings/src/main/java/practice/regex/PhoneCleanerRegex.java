package practice.regex;

import java.util.Scanner;

public class PhoneCleanerRegex {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    while (true) {
      String input = scanner.nextLine();
      String regex = "[^0-9]";
      String number = input.replaceAll(regex, "");
      String format1 = "[7][0-9]{3}[0-9]{3}[0-9]{2}[0-9]{2}";
      String format2 = "[0-9]{3}[0-9]{3}[0-9]{2}[0-9]{2}";
      String format3 = "[8][0-9]{3}[0-9]{3}[0-9]{2}[0-9]{2}";
      if (input.equals("0")) {
        scanner.close();
        break;
      } else if (number.matches(format1)) {
        System.out.println(number);
      } else if (number.matches(format2)) {
        System.out.println("7" + number);
      } else if (number.matches(format3)) {
        String regexCode = "[8]";
        String code = String.valueOf(number.charAt(0));
        String newCode = code.replaceAll(regexCode,"7");
        String newNumber = number.substring(code.length(),number.length());
        System.out.println(newCode + newNumber);
      } else {
        System.out.println("Неверный формат номера");
      }
      }
        // TODO:напишите ваш код тут, результат вывести в консоль.
    }
  }

