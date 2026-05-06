package homework17.Ex3;

import java.util.function.Function;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        double exchangeRate = 2.83;

        Function<String, Double> convertBynToUsd = input -> {
            String[] parts = input.trim().split(("\\s+"));
            double bynAmount = Double.parseDouble(parts[0]);

            return bynAmount / exchangeRate;
        };


        try {
            System.out.printf("%.2f\n", convertBynToUsd.apply("100 BYN"));
            System.out.printf("%.2f\n", convertBynToUsd.apply(" 100.1  BYN"));
            System.out.printf("%.2f\n", convertBynToUsd.apply("BYN 100"));
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат строки");
        }
    }
}
