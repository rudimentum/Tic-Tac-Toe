package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        printGame(line);
        System.out.println(printResult(line));
    }

    public static char[][] generateArray(String line) {
        char[][] symbols = new char[3][3];
        int index = 0;
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < symbols[i].length; j++) {
                symbols[i][j] = line.charAt(index++);
            }
        }
        return symbols;
    }

    public static void printGame(String line) {
        char[][] symbols = generateArray(line);
        System.out.println("---------");
        for (int i = 0; i < symbols.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < symbols[i].length; j++) {
                System.out.print(symbols[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static String printResult(String line) {
        char[][] symbols = generateArray(line);

        int xZeroCol = 0;
        int oZeroCol = 0;
        int xFirstCol = 0;
        int oFirstCol = 0;
        int xSecCol = 0;
        int oSecCol = 0;
        int xDiagonal = 0;
        int oDiagonal = 0;
        int xRevDiagonal = 0;
        int oRevDiagonal = 0;
        int xCountAll = 0;
        int oCountAll = 0;
        int emptyCount = 0;
        int reverseDiagonal = 2;
        for (int i = 0; i < symbols.length; i++) {
            int xRow = 0;
            int oRow = 0;
            if (symbols[i][i] == 'X') {
                xDiagonal++;
            } else if (symbols[i][i] == 'O') {
                oDiagonal++;
            }
            if (symbols[i][reverseDiagonal] == 'X') {
                xRevDiagonal++;
            } else if (symbols[i][reverseDiagonal] == 'O') {
                oRevDiagonal++;
            }
            reverseDiagonal--;
            for (int j = 0; j < symbols[i].length; j++) {
                if (j == 0) {
                    xZeroCol += symbols[i][j] == 'X' ? 1 : 0;
                    oZeroCol += symbols[i][j] == 'O' ? 1 : 0;
                } else if (j == 1) {
                    xFirstCol += symbols[i][j] == 'X' ? 1 : 0;
                    oFirstCol += symbols[i][j] == 'O' ? 1 : 0;
                } else {
                    xSecCol += symbols[i][j] == 'X' ? 1 : 0;
                    oSecCol += symbols[i][j] == 'O' ? 1 : 0;
                }

                if (symbols[i][j] == 'X') {
                    xRow++;
                } else if (symbols[i][j] == 'O') {
                    oRow++;
                } else {
                    emptyCount++;
                }
            }
            xCountAll += xRow;
            oCountAll += oRow;
            if (xRow == 3) {
                return "X wins";
            } else if (oRow == 3) {
                return "O wins";
            }
        }
        boolean xCol = xFirstCol == 3 || xZeroCol == 3 || xSecCol == 3;
        boolean oCol = oFirstCol == 3 || oZeroCol == 3 || oSecCol == 3;
        if (xCol && oCol) {
            return "Impossible";
        } else if (xCountAll - oCountAll >= 2 || oCountAll - xCountAll >= 2) {
            return "Impossible";
        } else if (xCol || xDiagonal == 3 || xRevDiagonal == 3) {
            return "X wins";
        } else if (oCol || oDiagonal == 3 || oRevDiagonal == 3) {
            return "O wins";
        } else if (emptyCount == 0 && (xCountAll - oCountAll < 2 || oCountAll - xCountAll < 2)) {
            return "Draw";
        } else {
            return "Game not finished";
        }
    }
}
