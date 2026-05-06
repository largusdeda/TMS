package homework17.Ex2;

import java.util.Arrays;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = {-1, 2, 0, -3, -5, 42, 1, 2};

        Arrays.stream(numbers)
                .filter(num -> num > 0)
                .forEach(System.out::println);
    }
}
