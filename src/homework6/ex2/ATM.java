package homework6.ex2;

import java.util.Map;

/**
 * @author Elena Chinarina
 *
 **/

public class ATM {
    private int count20;
    private int count50;
    private int count100;

    public ATM(int count20, int count50, int count100) {
        this.count20 = count20;
        this.count50 = count50;
        this.count100 = count100;
    }

    public void addMoney(Map<String, Integer> banknotes) {
        int new20 = banknotes.getOrDefault("20", 0);
        int new50 = banknotes.getOrDefault("50", 0);
        int new100 = banknotes.getOrDefault("100", 0);

        if (new20 >= 0 && new50 >= 0 && new100 >= 0) {
            this.count20 += new20;
            this.count50 += new50;
            this.count100 += new100;

            System.out.println("Деньги добавлены: " + banknotes);
            printBalance();
        } else {
            System.out.println("Значение купюр не может быть отрицательным.");
        }
    }

    public boolean withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Сумма снятия должна быть положительной.");
            return false;
        }

        int[] denominations = {100, 50, 20};
        int[] available = {count100, count50, count20};
        int[] result = new int[3];

        if (findCombination(amount, denominations, available, result, 0)) {
            count100 -= result[0];
            count50 -= result[1];
            count20 -= result[2];

            System.out.println("Выдана сумма: " + amount);
            for (int i = 0; i < denominations.length; i++) {
                if (result[i] > 0) {
                    System.out.printf("%d x %d = %d\n", result[i], denominations[i], result[i] * denominations[i]);
                }
            }
            System.out.println("\nОстаток в банкомате:");
            printBalance();

            return true;
        } else {
            System.out.printf("Невозможно выдать сумму %d имеющимися купюрами.", amount);
            return false;
        }
    }

    private boolean findCombination(int amount, int[] denominations,int[] available,
                                    int[] result, int index) {
        //сумма набрана полностью
        if (amount == 0) {
            return true;
        }

        //нет больше номиналов для проверки
        if (index >= denominations.length) {
            return false;
        }

        int currentDenom = denominations[index];
        int maxCount = Math.min(available[index], amount / currentDenom);

        //все возможные количества текущего номинала
        for (int count = maxCount; count >= 0; count--) {
            result[index] = count;
            int newAmount = amount - count * currentDenom;

            //проверка возможности набора остатка
            if (findCombination(newAmount, denominations, available, result, index + 1)) {
                return true;
            }
        }

        //нет подходящей комбинации
        result[index] = 0;
        return false;
    }

    public void printBalance() {
        System.out.println("Купюр по 20: " + count20);
        System.out.println("Купюр по 50: " + count50);
        System.out.println("Купюр по 100: " + count100);
    }

    public int getCount20() { return count20; }
    public int getCount50() { return count50; }
    public int getCount100() { return count100; }
}
