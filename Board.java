package TicTacToe;

import java.util.Arrays;

public class Board {
    private final BoardState[][] board = new BoardState[3][3];

    public Board() {
       Arrays.stream(board).forEach(row -> Arrays.fill(row, BoardState.EMPTY));
    }

    public boolean makeMove(Move move, BoardState state) {
        if(this.board[move.row()][move.col()] == BoardState.EMPTY) {
           this.board[move.row()][move.col()] = state;
           return true;
        }
        return false;
    }

    public BoardState getState(int row, int col) {
        return this.board[row][col];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BoardState[] row : this.board) {
            sb.append("\t");
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j]);
                if (j < row.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
