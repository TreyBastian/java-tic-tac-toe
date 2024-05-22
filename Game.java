package TicTacToe;

import java.util.Arrays;

public class Game {
    public char[][] board = new char[3][3];

    public void createBoard() {
        System.out.println("Let's play a game of Tic-Tac-Toe!");
        Arrays.stream(board).forEach(row -> Arrays.fill(row, '_'));
    }

    public void printBoard(char[][] game) {
        for (char[] row : game) {
            System.out.print("\t");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(char[][] board) {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] condition : winConditions) {
            if (board[condition[0] / 3][condition[0] % 3] == board[condition[1] / 3][condition[1] % 3] &&
                    board[condition[1] / 3][condition[1] % 3] == board[condition[2] / 3][condition[2] % 3] &&
                    board[condition[0] / 3][condition[0] % 3] != '_') {
                return true;
            }
        }
        return false;
    }

    public void playerTurn(Input choice) {
        for (int i = 0; i < 9; i++) {
            boolean validMove = false;
            while (!validMove) {
                int[] choices = choice.playerChoice(board);
                if (i % 2 == 0) {
                    System.out.println("Player X Turn");
                    if (board[choices[0]][choices[1]] == '_') {
                        board[choices[0]][choices[1]] = 'X';
                        validMove = true;
                    }
                    else {
                        System.out.println("Spot is already taken, please try again.");
                    }
                }
                else {
                    System.out.println("Player O Turn");
                    if (board[choices[0]][choices[1]] == '_') {
                        board[choices[0]][choices[1]] = 'O';
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
}
