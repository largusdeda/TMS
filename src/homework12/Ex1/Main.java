package homework12.Ex1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String input = scanner.nextLine();
        scanner.close();

//        String input = "Слова ABC, abc, НЕТ, ЗДЕСЬ, ABCDEFG. А, ПрИвЕт и числа 123ABC";

        // regex:
        // \b - граница слова
        // [A-ZА-Я]{2, 6} - от 2 до 6 заглавных букв
        // \b - граница слова
        Pattern pattern = Pattern.compile("\\b[A-ZА-Я]{2,6}\\b");
        Matcher matcher = pattern.matcher(input);

        System.out.println("Найденные аббревиатуры:");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
