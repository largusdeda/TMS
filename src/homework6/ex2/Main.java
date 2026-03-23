package homework6.ex2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(5, 5, 5);

        System.out.println("-- Исходное состояние -- ");
        atm.printBalance();

        System.out.println("-- Добавление купюр --");
        Map<String, Integer> banknotes = new HashMap<>();
        banknotes.put("20", 2);
        banknotes.put("50", 1);
        banknotes.put("100", 3);
        atm.addMoney(banknotes);

        System.out.println("-- Снятие денег --");
        atm.withdraw(1100);
    }
}
