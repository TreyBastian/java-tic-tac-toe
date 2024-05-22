package TicTacToe;

import java.util.Scanner;

public class Input {
    static Scanner input = new Scanner(System.in);

    public static int[] playerChoice(char[][] board) {
        int row, col;
        while (true) {
            System.out.print("Enter your move (row and column): ");
            row = input.nextInt();
            col = input.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '_') {
                break;
            } else {
                System.out.println("This is not a valid move. Please enter row and column between 0 and 2, and ensure the spot is empty.");
            }
        }
        return new int[]{row, col};
    }
}
