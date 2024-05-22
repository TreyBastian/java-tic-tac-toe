package TicTacToe;

import java.util.Scanner;

public class Input {
    private static final Scanner INPUT_SCANNER = new Scanner(System.in);

    public static Move getPlayerMove() {
     System.out.println("Enter the row and column number (0-2) separated by a space: ");
     Move input = getValidMove();

     if (input == null) {
         System.out.println("Invalid input. Please try again.");
         return getPlayerMove();
     }

     return input;
    }

    private static Move getValidMove() {
        int row = INPUT_SCANNER.nextInt();
        int col = INPUT_SCANNER.nextInt();

        if (validateInput(row, col)) {
            return new Move(row, col);
        }
        return null;
    }

    private static boolean validateInput(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
}
