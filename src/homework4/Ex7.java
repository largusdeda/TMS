package homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Ex7 {
    public static String convertArrayToString(Integer[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num);
        }
        return sb.toString();

    }

    public static Integer[] convertStringToArray(String str) {
        Integer[] array = new Integer[str.length()];

        for (int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i) - '0';
        }

        return array;
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 9, 9};
        System.out.println(Arrays.toString(arr));
        int arrAsInteger = Integer.parseInt(convertArrayToString(arr));
        arrAsInteger += 1;
        String arrAsString = Integer.toString(arrAsInteger);
        System.out.println(Arrays.toString(convertStringToArray(arrAsString)));

        System.out.println();

        //Для произвольных массивов
        Scanner in = new Scanner(System.in);
        Random random = new Random(); //для заполнения массива

        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        Integer[] randArr = new Integer[size];

        int lower = 1;
        int upper = 10;
        for (int i = 0; i < size; i++) {
            randArr[i] = random.nextInt(upper - lower) + lower;
        }

        System.out.println(Arrays.toString(randArr));
        int randArrAsInteger = Integer.parseInt(convertArrayToString(randArr));
        randArrAsInteger += 1;
        String randArrAsString = Integer.toString(randArrAsInteger);
        System.out.println(Arrays.toString(convertStringToArray(randArrAsString)));

        in.close();
    }
}
