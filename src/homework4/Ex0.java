package homework4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;

/**
 * @author Elena Chinarina
 *
 **/

public class Ex0 {
    static void reverse(Double[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    public static void main(String[] args) {
//        1. Создать пустой массив типа double с названием masDouble такого размера, который
//        пользователь вводит с клавиатуры.
//        2. Заполнить masDouble рандомными числами, используя Math.random() и вывести его в
//        консоль.
//        3. Каждый чётный элемент masDouble возвести в квадрат. Вывести массив в прямом и
//        обратном порядке.

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        Double[] masDouble = new Double[size];

        for (int i = 0; i < size; i++) {
            masDouble[i] = Math.random() * 100;
        }

        System.out.println("Исходный массив: " + Arrays.toString(masDouble));

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0)
                masDouble[i] = Math.pow(masDouble[i], 2);
        }

        System.out.println("Массив в прямом порядке: " + Arrays.toString(masDouble));
        reverse(masDouble);
        System.out.println("Массив в обратном порядке: " + Arrays.toString(masDouble));

        in.close();
    }
}
