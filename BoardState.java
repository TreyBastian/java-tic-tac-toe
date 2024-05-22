package TicTacToe;

public enum BoardState {
    X('X'),
    O('O'),
    EMPTY('_');

    private final char value;

    BoardState(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
