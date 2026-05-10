package homework18.Ex1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5, 6, 6, 7, 0, 9, 2));
        System.out.println("Исходный список: " + nums);
        int sumUniqueEvens = nums.stream()
                .distinct()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("Сумма всех уникальных четных чисел: " + sumUniqueEvens);
    }
}
