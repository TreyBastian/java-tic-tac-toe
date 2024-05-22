package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Game ticTacToe = new Game();
        Input choice = new Input();
        ticTacToe.createBoard();
        ticTacToe.printBoard(ticTacToe.board);
        ticTacToe.playerTurn(choice);
    }
}
