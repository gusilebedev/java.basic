package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 13;
        int month = 05;
        int year = 1993;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year,month,day);
        LocalDate toDay = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        int i = 0;
        String text = "";

        while (birthday.isBefore(toDay) || birthday.isEqual(toDay)) {
            text = text + i + " - " + formatter.format(birthday) + System.lineSeparator();
            birthday = birthday.plusYears(1);
            i++;
        }
        return text;


        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
    }
}
