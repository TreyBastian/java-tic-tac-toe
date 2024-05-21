package TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class Game extends Main {
    static char[][] board = new char[3][3];
    static Scanner input = new Scanner(System.in);

    public static char[][] createBoard() {
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '_');
        }
        return board;
    }

    public static void printBoard(char[][] game) {
        for (int i = 0; i < game.length; i++) {
            System.out.print("\t"); // Print a tab at the beginning of each line
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(game[i][j]);
                if (j < game[i].length - 1) {
                    System.out.print(" "); // Print a space between elements
                }
            }
            System.out.println(); // Move to the next line after each row
        }
    }


    public static int[][] winConditions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {2, 4, 6},
            {0, 4, 8}
    };

    public static boolean checkWinner(char[][] board) {
        for (int[] condition : winConditions) {
            if (board[condition[0] / 3][condition[0] % 3] == board[condition[1] / 3][condition[1] % 3] &&
                    board[condition[1] / 3][condition[1] % 3] == board[condition[2] / 3][condition[2] % 3] &&
                    board[condition[0] / 3][condition[0] % 3] != '_') {
                return true;
            }
        }
        return false;
    }

    public static void playerTurn() {
        for (int i = 0; i < 9; i++) {
            boolean validMove = false;
            while (!validMove) {
                if (i % 2 == 0) {
                    System.out.println("Player X Turn");
                    int[] playerMove = playerChoice(board);
                    if (board[playerMove[0]][playerMove[1]] == '_') {
                        board[playerMove[0]][playerMove[1]] = 'X';
                        validMove = true;
                    }
                    else {
                        System.out.println("Spot is already taken, please try again.");
                    }
                }
                else {
                    System.out.println("Player O Turn");
                    int[] playerMove = playerChoice(board);
                    if (board[playerMove[0]][playerMove[1]] == '_') {
                        board[playerMove[0]][playerMove[1]] = 'O';
                        validMove = true;
                    }
                    else {
                        System.out.println("Spot is already taken, please try again.");
                    }
                }
            }
            printBoard(board);
            if (checkWinner(board)) {
                System.out.println((i % 2 == 0 ? "Player X" : "Player O") + " wins!");
                return;
            }
        }
        System.out.println("It's a draw!");
    }

    public static int[] playerChoice(char[][] board) {
        int row, col;
        while (true) {
            System.out.print("Enter your move (row and column): ");
            row = input.nextInt();
            col = input.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                break;
            }
            else {
                System.out.println("This is not a valid move. Please enter row and column between 0 and 2.");
            }
        }
        return new int[]{row, col};
    }

}
