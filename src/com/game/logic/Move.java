package com.game.logic;

import com.game.entities.Player;
import com.game.objects.Board;
import com.game.objects.Checker;
import com.game.util.GameException;

// Represents a valid move in Checkers
public class Move {
    private final int fromRow;
    private final int fromCol;
    private final int toRow;
    private final int toCol;
    private boolean isCapture;

    public Move(int fromRow, int fromCol, int toRow, int toCol) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public boolean isValid(Board board, Player player) {
        return validateDirection(board, player)
            && validateStepSize();
    }

    private boolean validateDirection(Checker piece) {

        // for non king pieces.
        if (!piece.isKing()) {
            int rowDiff = toRow - fromRow;
            String color = piece.getColor();

            if ("RED".equals(color)) {
                return rowDiff > 0; // Red moves forward
            } else { // BLACK must move backward
                return rowDiff < 0;
            }
        }

    }

    private boolean validateStepSize() {
        int colDiff = Math.abs(fromCol - toCol);
        return (Math.abs(fromRow - toRow) == 1 && colDiff == 1) ||
               (Math.abs(fromRow - toRow) == 2 && colDiff == 2);
    }

    public void moveChecker(int fromRow, int fromCol, int toRow, int toCol ){

    }

    public boolean validateCaptureMove(int startRow, int startCol, int endRow, int endCol) {
        // Check if move is diagonal capture (e.g., 1 row/col difference)
        return Math.abs(endRow - startRow) == 2 &&
                Math.abs(endCol - startCol) == 2 &&
                !isPositionEmpty((startRow + endRow)/2, (startCol + endCol)/2);
    }
}
