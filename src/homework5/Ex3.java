package homework5;

import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n, m;

        System.out.println("Введите количество строк: ");
        n = in.nextInt();
        System.out.println("Введите количество столбцов: ");
        m = in.nextInt();

        in.close();

        int[][] arr = new int[n][m];

        int value = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = value++;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    arr[i][j] = value++;
                }
            }
        }

        System.out.println("Массив:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
