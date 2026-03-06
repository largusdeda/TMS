package homework1;

import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Homework1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        {
            /* ************** ЗАДАЧА №1 *************** */

            System.out.println("Задача 1");

            System.out.print("Введите b (ввод дробной части через запятую): ");
            float b = in.nextFloat();
            System.out.print("Введите c (ввод дробной части через запятую): ");
            float c = in.nextFloat();

            System.out.printf("Результат: a = 4 * (%f + %f - 1) / 2) = %f\n", b, c, 2 * (b + c - 1));
        }

        {
            /* ************** ЗАДАЧА №2 *************** */

            System.out.println("\nЗадача 2");

            int n = 42;
            System.out.println("n = " + n);
            System.out.println("Сумма цифр: " + (n % 10 + n / 10));
        }

        {
            /* ************** ЗАДАЧА №3 *************** */

            System.out.println("\nЗадача 3");

            int n = 999;
            System.out.println("n = " + n);
            System.out.println("Сумма цифр: " + (n % 10 + n / 10 % 10 + n / 100));
        }

        {
            /* ************** ЗАДАЧА №4 *************** */

            System.out.println("\nЗадача 4");

            System.out.print("Введите n (ввод дробной части через запятую): ");
            float n = in.nextFloat();

            int floor;
            float frac;
            if (n >= 0) {
                floor = (int)n;
                frac = n - floor;
            } else {
                if (n == (int)n) {
                    floor = (int)n;
                    frac = 0.0f;
                } else {
                    floor = (int)n - 1;
                    frac = n - floor;
                }
            }

            System.out.println(frac >= 0.5 ? floor + 1 : floor);
        }

        {
            /* ************** ЗАДАЧА №5 *************** */

            System.out.println("\nЗадача 5");

            System.out.print("Введите q: ");
            int q = in.nextInt();
            System.out.print("Введите w (!= 0): ");
            int w = in.nextInt();

            System.out.printf("Результат: %d / %d = %d и %d в остатке\n", q, w, q / w, q % w);
        }

        {
            /* ************** ЗАДАЧА №6 *************** */

            System.out.println("\nЗадача 6");

            System.out.print("Введите a: ");
            int a = in.nextInt();
            System.out.print("Введите b: ");
            int b = in.nextInt();

            System.out.printf("Было: a = %d b = %d", a, b);

            a ^= b;
            b ^= a;
            a ^= b;

            System.out.printf("\nСтало: a = %d b = %d", a, b);
        }

        in.close();
    }
}