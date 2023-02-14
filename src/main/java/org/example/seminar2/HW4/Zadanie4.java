package org.example.seminar2.HW4;

import java.util.Arrays;

public class Zadanie4 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = {
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}};
        System.out.println("с точками = " + validSudoku(board));
        System.out.println("решенный = " + validSudoku(board2));
    }

    public static boolean validSudoku(char[][] array) {
        int[] colomsArr = new int[9];
        int[] rowsArr = new int[9];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (49 < array[i][j] && array[i][j] > 57) return false;
                colomsArr[j] = Character.digit(array[i][j], 10);
                rowsArr[j] = Character.digit(array[j][i], 10);
            }
            if (Arrays.stream(colomsArr).sum() != 45 && Arrays.stream(rowsArr).sum() != 45) return false;
            colomsArr = new int[9];
            rowsArr = new int[9];
        }
        int[][] referenceArr = new int[9][9];
        int indexColoms = 0;
        int indexRows = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                referenceArr[(int) Math.floor(j / 3) + indexRows][indexColoms] = Character.digit(array[i][j], 10);
                indexColoms++;
                if (indexColoms % 3 == 0) indexColoms -= 3;
            }
            indexColoms += 3;
            if (indexColoms == 9) indexColoms = 0;
            if (i == 2 || i == 5) indexRows += 3;
        }
        for (int[] ints : referenceArr) {
            if (Arrays.stream(ints).sum() != 45) return false;
        }
        return true;
    }
}
