package homework2;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Elena Chinarina
 **/
public class Homework2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        {
            /* ************** ЗАДАЧА №1 *************** */

            System.out.println("Задача 1");

            System.out.println("Введите целое число:");
            if (in.hasNextInt()) {
                int num = in.nextInt();
                boolean isEven = num % 2 == 0;
                System.out.printf("Число %d - %s", num, isEven ? "чётное\n" : "нечётное\n");
            } else {
                System.out.printf("\"%s\" - не целое число :(\n", in.next());
            }
        }

        {
            /* ************** ЗАДАЧА №2 *************** */

            System.out.println("\nЗадача 2");

            System.out.println("Введите значение температуры:");
            if (in.hasNextInt() || in.hasNextDouble()) {
                double t = Double.parseDouble(in.next());
                String weather = t > -5 ? "Тепло" :
                        (t <= -5 && t > -20) ? "Нормально" : "Холодно";
                System.out.println(weather);
            } else {
                System.out.printf("\"%s\" - некорректный ввод\n", in.next());
            }
        }

        {
            /* ************** ЗАДАЧА №3 *************** */

            System.out.println("\nЗадача 3");

            for (int i = 10; i <= 20; i++) {
                System.out.print((int) Math.pow(i, 2) + " ");
            }
            System.out.println();
        }

        {
            /* ************** ЗАДАЧА №4 *************** */

            System.out.println("\nЗадача 4");

            System.out.println("Введите целое число:");
            if (in.hasNextInt()) {
                int num = in.nextInt();
                int cnt = 1;
                while (cnt <= 14) {
                    System.out.print(num * cnt + " ");
                    cnt++;
                }
            } else {
                System.out.printf("\"%s\" - не целое число\n", in.next());
            }

            System.out.println();
        }

        {
            /* ************** ЗАДАЧА №5 *************** */

            System.out.println("\nЗадача 5");

            int inputNum;
            boolean correctInput = false;
            while (!correctInput) {
                System.out.println("Введите целое положительное число:");

                if (!in.hasNextInt()) {
                    System.out.printf("\"%s\" - не целое число\n", in.next());
                } else {
                    inputNum = in.nextInt();
                    if (inputNum <= 0) {
                        System.out.printf("%d - не положительное число\n", inputNum);
                    } else {
                        int sum = 0;
                        for (int i = 1; i <= inputNum; i++) {
                            sum += i;
                        }
                        System.out.printf("Сумма чисел от 1 до %d: %d", inputNum, sum);

                        // Выход
                        correctInput = true;
                    }
                }
            }
        }

        in.close();
    }
}