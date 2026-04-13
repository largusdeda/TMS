package homework11.Ex6;

import homework11.StringUtils;

import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку: ");

        String inputLine = scanner.nextLine();

        if (inputLine == null || inputLine.isBlank()) {
            System.out.println("Введена пустая строка");
            scanner.close();
            return;
        }

        String[] words = inputLine.trim().split(("\\s+"));

        System.out.println("Строка содержит следующие слова: ");
        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ". " + words[i]);
        }

        System.out.println("\nВведите номер слова: ");
        int wordNumber;

        try {
            wordNumber = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введено не число");
            scanner.close();
            return;
        }

        if (wordNumber < 1 || wordNumber > words.length) {
            System.out.println("Введен некорректный номер");
            scanner.close();
            return;
        }

        boolean isPalindromeWord = StringUtils.isPalindrome(words[wordNumber - 1]);
        System.out.println(isPalindromeWord ? "Палиндром" : "Не палиндром");
        scanner.close();
    }
}
