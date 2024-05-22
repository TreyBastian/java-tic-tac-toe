package TicTacToe;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board = new Board();

    public boolean checkWinner() {
        int[][] winConditions = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}, // Rows
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8}, // Columns
                {0, 4, 8},
                {2, 4, 6}             // Diagonals
        };

        for (int[] condition : winConditions) {
           BoardState peice = this.board.getState(condition[0] / 3, condition[0] % 3);
            if (peice != BoardState.EMPTY) {
                // check the rest
                // if winner return true
            }

            if (board[condition[0] / 3][condition[0] % 3] == board[condition[1] / 3][condition[1] % 3] &&
                    board[condition[1] / 3][condition[1] % 3] == board[condition[2] / 3][condition[2] % 3] &&
                    board[condition[0] / 3][condition[0] % 3] != '_') {
                return true;
            }
        }
        return false;
    }

    public void playerTurn() {
        for (int i = 0; i < 9; i++) {
            Move move = Input.getPlayerMove();
            if (i % 2 == 0) {
                System.out.println("Player X Turn");
                if (!board.makeMove(move, BoardState.X)) {
                    System.out.Println("Spot is already taken, please try again.");
                }
            } else {
                System.out.println("Player O Turn");
                if (board[choices[0]][choices[1]] == '_') {
                    board[choices[0]][choices[1]] = BoardState.O;
                    validMove = true;
                } else {
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
