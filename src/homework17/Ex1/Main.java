package homework17.Ex1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения:");
        String input = scanner.nextLine();
        scanner.close();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate birthDate = LocalDate.parse(input, formatter);
            LocalDate hundredYearsLater = birthDate.plusYears(100);
            System.out.println("Столетие будет " + hundredYearsLater.format(formatter) + " (но это не точно)");
        } catch (DateTimeParseException e) {
            System.out.println("Неверный формат даты. Используйте гггг-мм-дд");
        }
    }
}
