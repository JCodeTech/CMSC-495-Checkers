/**
 * UMGC CMSC 495
 * Developers: Joseph Romano
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.logic;

import com.game.objects.Board;
import com.game.objects.Checker;

/* Example of how this class is used:
    // When user clicks to move a piece
    int fromRow = 2, fromCol = 3;
    int toRow = 4, toCol = 5;

    // Create MoveValidation object with the coordinates
    MoveValidation move = new MoveValidation(fromRow, fromCol, toRow, toCol);

    // Validate the move
    boolean isValid = move.validateMove(currentBoard, currentPlayer);
 */
public class Move {
    private final int fromRow;
    private final int fromCol;
    private final int toRow;
    private final int toCol;
    private boolean isCapture;
    Board board = new Board();

    public Move(int fromRow, int fromCol, int toRow, int toCol) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    // Method to move a checker from one position to another
    public void moveChecker(int fromRow, int fromCol, int toRow, int toCol, Board board) {
        Checker[][] checkerBoard = board.getCheckerPiece(); // Gets the current state of the board
        // Get the checker from source position
        Checker piece = checkerBoard[fromRow][fromCol];

        // Remove piece from source position (set to null)
        checkerBoard[fromRow][fromCol] = null;

        // Place piece at destination position
        checkerBoard[toRow][toCol] = piece;
    }

    // Check if a piece should be promoted to king
    private void checkForKingPromotion(int row, int col) {
        if (row == 0 || row == 7) { // Top or bottom of the board
            board.promoteToKing(row, col);
        }
    }

    // Handle capture logic
    private void handleCapture(int fromRow, int fromCol, int toRow, int toCol) {
        // Calculate middle position
        int midRow = fromRow + (toRow - fromRow) / 2;
        int midCol = fromCol + (toCol - fromCol) / 2;

        // Clear the captured piece
        board.clearPosition(midRow, midCol);
    }

}
