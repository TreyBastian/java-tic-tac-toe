package TicTacToe;

public class Main {
    public static void main(String[] args) {
        Game TicTacToe = new Game();
        System.out.println("Let's play a game of Tic-Tac-Toe!");
        char[][] gameBoard = TicTacToe.createBoard();
        TicTacToe.printBoard(gameBoard);
        TicTacToe.playerTurn();
    }
}
