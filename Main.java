package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Game ticTacToe = new Game();
        ticTacToe.createBoard();
        ticTacToe.printBoard(ticTacToe.board);
        ticTacToe.playerTurn();
    }
}
