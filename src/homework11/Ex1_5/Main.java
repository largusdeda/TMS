package homework11.Ex1_5;

import homework11.StringUtils;

import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[3];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую строку:");
        strings[0] = scanner.nextLine();
        System.out.println("Введите вторую строку:");
        strings[1] = scanner.nextLine();
        System.out.println("Введите третью строку:");
        strings[2] = scanner.nextLine();

        /************************************* № 1 *************************************/
        System.out.println("Ex1");

        String shortest = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() < shortest.length())
                shortest = strings[i];
        }

        String longest = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > longest.length())
                longest = strings[i];
        }

        System.out.printf("Самая длинная строка: %s (длина: %d)\n", longest, longest.length());
        System.out.printf("Самая короткая строка: %s (длина: %d)\n", shortest, shortest.length());

        System.out.println();

        /************************************* № 2 *************************************/
        System.out.println("Ex2");

        String middle = (!strings[0].equals(shortest)) && (!strings[0].equals(longest)) ? strings[0] :
                        (!strings[1].equals(shortest)) && (!strings[1].equals(longest)) ? strings[1] :
                        strings[2];

        System.out.printf("Строки в порядке возрастания длины:\n%s\n%s\n%s\n", shortest, middle, longest);

        System.out.println();

        /************************************* № 3 *************************************/
        System.out.println("Ex3");

        for (String str : strings) {
            if (str.length() < strings[1].length())
                System.out.printf("%s (длина: %d)\n", str, str.length());
        }

        System.out.println();

        /************************************* № 4 *************************************/
        System.out.println("Ex4");

        String firstUniqueWord = StringUtils.findFirstUniqueWord(strings);
        System.out.println(firstUniqueWord != null ?
                "Первое найденное слово с уникальными символами: " + firstUniqueWord :
                "Слов, состоящих из различных символов, не найдено");

        System.out.println();

        /************************************* № 5 *************************************/
        System.out.println("Ex5");

        System.out.println("Введите слово:");
        String word = scanner.nextLine();
        System.out.println(StringUtils.duplicateCharacters(word));


        scanner.close();
    }
}
