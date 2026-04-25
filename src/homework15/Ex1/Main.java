package homework15.Ex1;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числа:");

        String input = scanner.nextLine();

        scanner.close();

        String[] numbersArray = input.split("[,\\s]+");

        Set<String> uniqueNumbers = new LinkedHashSet<>();

        for (String num : numbersArray) {
            uniqueNumbers.add(num.trim());
        }

        System.out.println("Результат:");
        System.out.println(String.join(", ", uniqueNumbers));
    }
}
