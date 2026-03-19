package homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Ex6 {
    public static boolean isIncreasing(Integer[] array) {
        if (array.length <= 1)
            return true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1])
                return false; //найден элемент меньше предыдущего или равный ему
        }

        return true;
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

        System.out.println("Массив: " + Arrays.toString(arr));

        if (isIncreasing(arr))
            System.out.println("Массив является возрастающей последовательностью :^)");
        else
            System.out.println("Массив не является возрастающей последовательностью :^(");

        Arrays.sort(arr);
        //После сортировки по возрастанию
        System.out.println("Массив: " + Arrays.toString(arr));
        if (isIncreasing(arr))
            System.out.println("Массив является возрастающей последовательностью :^)");
        else
            System.out.println("Массив не является возрастающей последовательностью :^(");


        in.close();
    }
}
