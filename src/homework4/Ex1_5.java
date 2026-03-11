package homework4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Ex1_5 {
    static void reverse(Integer[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random(); //для заполнения массива

        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }

        /* ************** ЗАДАЧА №1 *************** */
        System.out.println("Массив в прямом порядке: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Массив в обратном порядке: " + Arrays.toString(arr));

        System.out.println();

        /* ************** ЗАДАЧА №2 *************** */
        int min = Collections.min(Arrays.asList(arr));
        int max = Collections.max(Arrays.asList(arr));
        System.out.printf("Минимальный элемент массива - %d, максимальный элемент  массива - %d\n", min, max);

        System.out.println();

        /* ************** ЗАДАЧА №3 *************** */
        int indexOfMin = (Arrays.asList(arr)).indexOf(min);
        int indexOfMax = (Arrays.asList(arr)).indexOf(max);
        System.out.printf("Индекс минимального элемента массива - %d, " +
                "индекс максимального элемента  массива - %d\n", indexOfMin, indexOfMax);

        System.out.println();

        /* ************** ЗАДАЧА №4 *************** */
        int countZeroes = 0;
        for (Integer el : arr) {
            if (el == 0)
                countZeroes++;
        }

        if (countZeroes > 0)
            System.out.printf("В массиве есть нулевые элементы в количестве: %d\n", countZeroes);
        else
            System.out.println("В массиве нет нулевых элементов\n");

        /* ************** ЗАДАЧА №5 *************** */
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        for (int i = 0; i < size / 2; i++) {
//            //XOR
//            arr[i] ^= arr[size - 1 - i];
//            arr[size - 1 - i] ^= arr[i];
//            arr[i] ^= arr[size - 1 - i];

            Collections.swap(Arrays.asList(arr), i, size - 1 - i);
        }

        System.out.println("Получившийся массив: " + Arrays.toString(arr));

        in.close();
    }
}
