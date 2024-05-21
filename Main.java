package TicTacToe;

public class Main {
    public static void main(String[] args) {
        char[][] gameBoard = Game.createBoard();
        System.out.println("Let's play a game of Tic-Tac-Toe!");
        Game.printBoard(gameBoard);
        Game.playerTurn();
    }
}
