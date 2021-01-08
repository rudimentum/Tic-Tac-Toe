package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char [][] gameState = new char[3][3];
        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState.length; j++) {
                gameState[i][j] = ' ';
            }
        }
        TicTacToe.printGame(gameState);
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                gameState = TicTacToe.enterCoordinates(gameState, 'X');
            } else {
                gameState = TicTacToe.enterCoordinates(gameState, 'O');
            }
            TicTacToe.printGame(gameState);
            String condition = TicTacToe.printResult(gameState);
            if (!condition.equals("Game not finished")) {
                System.out.println(condition);
                break;
            }
        }
    }
}
