/**
 * UMGC CMSC 495
 * Developers: Joseph Romano
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.logic;

import com.game.entities.Player;
import com.game.objects.Board;
import com.game.objects.BoardSquare;
import com.game.objects.Checker;
import com.game.ui.BoardUI;
import com.game.util.GameException;

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
    private final Board board;
    private BoardUI checkerUI;
    private MoveValidation move;
    private MoveValidation checkMove;

    public Move(Board board, int fromRow, int fromCol, int toRow, int toCol) {
        this.board = board;
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    // Method to move a checker from one position to another
    public void moveChecker(Checker piece, BoardSquare space) {
        Checker[][] checkerBoard = board.getCheckerPiece(); // Gets the current state of the board

        // Remove piece from source position (set to null)
        board.clearPosition(fromRow, fromCol);

        // Place piece at destination position (For Board Class, NEEDS REFACTORING!!!!)
        checkerBoard[toRow][toCol] = piece;
        piece.setNewPos(space.getRow(), space.getCol());

        checkForKingPromotion(piece);
        checkerUI.updateCheckerPieceUI();
    }

    // Check if a piece should be promoted to king
    private void checkForKingPromotion(Checker piece) {
        if (piece.getRow() == 0 || piece.getRow() == 7) { // Top or bottom of the board
            board.promoteToKing(piece.getRow(), piece.getCol());
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

    public void makeMove() throws GameException {
        BoardSquare space = (BoardSquare) board.findSelected("space");
        Checker piece = (Checker) board.findSelected("checker");

        boolean isValid = move.validateMove(piece, space);

        if (isValid) {
            moveChecker(piece, space);
        }
    }


}
