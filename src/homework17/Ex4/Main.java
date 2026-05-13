package homework17.Ex4;

import java.util.function.Consumer;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        double exchangeRate = 2.83;

        Consumer<String> convertBynToUsdNPrint = input -> {
            String[] parts = input.trim().split(("\\s+"));
            double bynAmount = Double.parseDouble(parts[0]);

            System.out.printf("%.2f\n", bynAmount / exchangeRate);
        };


        try {
            convertBynToUsdNPrint.accept("100 BYN");
            convertBynToUsdNPrint.accept(" 100.1  BYN");
            convertBynToUsdNPrint.accept("BYN 100");
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат строки");
        }
    }
}