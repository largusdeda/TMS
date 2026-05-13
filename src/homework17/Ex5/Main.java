package homework17.Ex5;

import java.util.Scanner;
import java.util.function.Supplier;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Supplier<String> reverseInputSupplier = () -> {
            String input = readFromConsole();
            return reverseString(input);
        };

        System.out.println(reverseInputSupplier.get());

    }

    private static String readFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите строку: ");
            return scanner.nextLine();
        }
    }

    private static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
