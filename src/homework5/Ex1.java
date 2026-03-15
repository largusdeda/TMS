package homework5;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Ex1 {
    public static void main(String[] args) {
        Random random = new Random();

        Integer[][] matrix = new Integer[2][3];

        System.out.println("Массив: ");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(11);
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }

        Scanner in = new Scanner(System.in);

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Введите число, которое нужно прибавить к элементу [%d][%d]:\n", i, j);
                int input = in.nextInt();
                matrix[i][j] += input;
                sum += matrix[i][j];
            }
        }

        in.close();

        System.out.println("\nПолучившийся массив: ");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println("Сумма элементов: " + sum);
    }
}
