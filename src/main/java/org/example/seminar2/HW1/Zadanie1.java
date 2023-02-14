package org.example.seminar2.HW1;

import java.util.Scanner;

public class Zadanie1 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.print("Задайте длинну последовательности: ");
        int n = userInput();
        System.out.println("Введите последовательность: ");
        for (int i = 0; i < n; i++) {
            int num = userInput();
            if (isPrimeNumber(num)) {
                sum += num;
            }
        }
        System.out.println("Сумма простых чисел в последовательности = " + sum);
    }

    /**
     * Проверяет является ли число простым
     *
     * @param num целочисленное значение
     * @return true - если число простое, иначе false
     */
    public static boolean isPrimeNumber(int num) {
        if (num > 0) {
            for (int i = 2; i < num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
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
