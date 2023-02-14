package org.example.seminar2.HW2;

import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        System.out.print("Задайте длинну последовательности: ");
        int n = userInput();
        System.out.println("Введите последовательность: ");
        int num1 = userInput();
        boolean flag = true;
        while (n > 0) {
            int num2 = userInput();
            if (num1 < num2) {
                num1 = num2;
                n--;
            } else {
                flag = false;
                n = 0;
            }
        }
        if (flag) {
            System.out.println("Последовательность возврастающая!");
        } else {
            System.out.println("Последовательно не является возврастающей!");
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
