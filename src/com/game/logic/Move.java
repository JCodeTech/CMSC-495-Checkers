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
        this.isCapture = Math.abs(fromRow - toRow) == 2; // Capture detection
    }

    public boolean isValid(Board board, Player player) {
        return validateDirection(board, player)
            && validateStepSize()
            && (isCapture ? validateCapture(board, player) : true);
    }

    private boolean validateDirection(Board board, Player player) {
        int rowDiff = toRow - fromRow;
        String color = player.getColor();

        if ("RED".equals(color)) {
            return rowDiff > 0; // Red moves forward
        } else { // BLACK must move backward
            return rowDiff < 0;
        }
    }

    private boolean validateStepSize() {
        int colDiff = Math.abs(fromCol - toCol);
        return (Math.abs(fromRow - toRow) == 1 && colDiff == 1) ||
               (Math.abs(fromRow - toRow) == 2 && colDiff == 2);
    }

    private boolean validateCapture(Board board, Player player) {
        if (!isCapture) return false;

        int captureRow = (fromRow + toRow) / 2;
        int captureCol = (fromCol + toCol) / 2;

        Piece capturedPiece = board.getPiece(captureRow, captureCol);
        return capturedPiece != null &&
               !player.getColor().equals(capturedPiece.getColor());
    }

    public void execute(Board board) {
        if (!isValid(board, player)) throw new IllegalStateException("Invalid move");
        // Board logic to update positions
    }
}
