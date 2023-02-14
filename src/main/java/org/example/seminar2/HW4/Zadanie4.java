package org.example.seminar2.HW4;

import java.util.HashSet;

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
        System.out.println("Валидность доски = " + isValidSudokuDesk(board));
    }

    public static boolean isValidSudokuDesk(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> columnsSet = new HashSet<>();
            for (int j = 0; j < arr[i].length; j++) {
                char symbol = arr[i][j];
                if (rowSet.contains(symbol)) return false;
                if (symbol != '.') rowSet.add(symbol);
                symbol = arr[j][i];
                if (columnsSet.contains(symbol)) return false;
                if (symbol != '.') columnsSet.add(symbol);
            }
        }
        int row = 0;
        int column = 0;
        for (int i = 0; i < 9; i++) {
            HashSet<Character> blockSet = new HashSet<>();
            for (int j = row; j < row + 3; j++) {
                for (int k = column; k < column + 3; k++) {
                    char symbol = arr[j][k];
                    if (blockSet.contains(symbol)) return false;
                    if (symbol != '.') blockSet.add(symbol);
                }
            }
            column += 3;
            if (column == 9) {
                column = 0;
                row += 3;
            }
        }
        return true;
    }
}
