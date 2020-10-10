package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] symbols = line.split("");
        System.out.println("---------");
        int index = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(symbols[index++] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}