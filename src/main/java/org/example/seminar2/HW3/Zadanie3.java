package org.example.seminar2.HW3;

import java.util.Arrays;
import java.util.Scanner;

public class Zadanie3 {
    public static void main(String[] args) {
        System.out.print("Введите длину массива: ");
        int length = userInput();
        int[] arr = new int[length];
        int sumIndex = 0;
        System.out.println("Введите данные в массив:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = userInput();
            if ((arr[i] > 9 && arr[i] < 100) || (arr[i] < -9 && arr[i] > -100)) {
                sumIndex += i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) arr[i] = sumIndex;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Принимает ввод пользователя и
     * проверяет на корректность ввода
     *
     * @return целое число
     */
    public static int userInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.print("Ошибка ввода!\nВведите целое число: ");
                sc.next();
            }
        }
    }
}
