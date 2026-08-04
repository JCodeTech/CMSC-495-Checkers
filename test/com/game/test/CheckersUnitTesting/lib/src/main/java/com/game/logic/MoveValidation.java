/**
 * UMGC CMSC 495
 * Developers: Joseph Romano
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.logic;

import com.game.core.Controller;
import com.game.entities.Player;
import com.game.objects.Board;
import com.game.objects.BoardSquare;
import com.game.objects.Checker;
import com.game.util.GameException;

// Represents a valid move in Checkers

/* Example of how this class is used:
    // When user clicks to move a piece
    int fromRow = 2, fromCol = 3;
    int toRow = 4, toCol = 5;

    // Create MoveValidation object with the coordinates
    MoveValidation move = new MoveValidation(fromRow, fromCol, toRow, toCol);

    // Validate the move
    boolean isValid = move.validateMove(currentBoard, currentPlayer);
 */
public class MoveValidation {
    boolean isCapture = false;
    Board board;

    public MoveValidation(Board board) {
        this.board = board;
    }

    public boolean validateMove(Checker piece, BoardSquare space) throws GameException {


        if (piece == null){
            throw new GameException("You did not select a Checker. Please select a Checker.");
        }

        // Checks to see if destination is empty.
        if (space == null) {
            throw new GameException("You must choose an empty spot.");
        }

        int toCol = space.getCol();
        int toRow = space.getRow();
        int fromRow = piece.getRow();
        int fromCol = piece.getCol();

        if (toCol < 0 || toCol > 7 || toRow < 0 || toRow > 7){
            throw new GameException("Invalid move to " + toRow + ", " + toCol + ". You must move your piece within the game board"); // This should not be in the game.
        }

        if(board.getCheckerPiece()[toRow][toCol] != null){
            throw new GameException("Destination square is already occupied.");
        }

        final int difRow = Math.abs(toRow - fromRow);
        final int difCol = Math.abs(toCol - fromCol);

        // Check if fromSpace belongs to the player
        if ((Controller.getPlayerTurn() && piece.getColor().equals("Black")) || (!Controller.getPlayerTurn() && piece.getColor().equals("Red"))) {
            System.out.println(piece.getColor());
            throw new GameException("Cannot move opponent's Checker");
        }


        if (difRow !=1 && difRow != 2){
            throw new GameException("Pieces can only move one to two spaces diagonally.");
        }

        // Checks if move is diagonal (Must implement further checks if we implement multiple moves in one validation for multiple captures)
        if (difRow != difCol){
            throw new GameException("Invalid move. You must move your pieces diagonally.");
        }

        // Ensures that the destination of a fromSpace is accordance with the allowed move direction.
        if (piece.getColor().equals("Black") && !piece.isKing() && toRow < fromRow){
            throw new GameException("Invalid move. Non-Kinged Black pieces can only move down the board.");
        }

        // Ensures that the destination of a fromSpace is accordance with the allowed move direction.
        if (piece.getColor().equals("Red") && !piece.isKing() && toRow > fromRow){
            throw new GameException("Invalid move. Non-Kinged Red pieces can only move up the board.");
        }

        // Checks if the current fromSpace is moving to a valid position (within bounds)
        if (toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            throw new GameException("Invalid move. Position is out of bounds.");
        }

        // Validations of Capture Moves
        if (difCol == 2 && difRow == 2){
            isCapture = true;

            // Find the middle position that should contain the opponent piece
            int midRow = fromRow + (toRow - fromRow) / 2;
            int midCol = fromCol + (toCol - fromCol) / 2;

            Checker[][] currentBoard = board.getCheckerPiece();
            Checker midSpace = currentBoard[midRow][midCol]; // Sets the calculated mid-section between move to variable.

            // Check if there's a piece at the middle position
            if (midSpace == null) {
                throw new GameException("Invalid capture move. No piece to capture at " + midRow + ", " + midCol);
            }

            // Check if the middle piece belongs to the opponent
            if (midSpace.getColor().equals(piece.getColor())) {
                throw new GameException("Cannot capture your own piece.");
            }

        }


        return true;
    }

    public boolean isCapture() {
        return isCapture;
    }

}
