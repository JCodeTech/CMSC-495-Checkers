/**
 * UMGC CMSC 495
 * Developers: Joseph Romano
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.logic;

import com.game.entities.Player;
import com.game.objects.Board;
import com.game.objects.Checker;
import com.game.util.GameException;

// Represents a valid move in Checkers

/* Example of how this class is used:
    // When user clicks to move a piece
    int fromRow = 2, fromCol = 3;
    int toRow = 4, toCol = 5;

    // Create Move object with the coordinates
    Move move = new Move(fromRow, fromCol, toRow, toCol);

    // Validate the move
    boolean isValid = move.validateMove(currentBoard, currentPlayer);
 */
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

    /* Use move.validateMove(board, player) in logic when checking for validation.
        * This method needs to check:
        * If move is diagonal.
        * If move is in the right direction based off of the color of the checker and whether the checker is a king or not.
        * If move is a capture move of the opposing checker.
        * If move is within board bounds.
        * If move is not on top of another checker.
     */

    // TODO: Validate that a player must capture if possible

    // We can use this method to highlight every valid space, but we need to have it return the boolean for each if condition.
    public boolean validateMove(Board board, Player player) throws GameException {
        Checker[][] currentBoard = board.getBoard(); // Gets the current state of the board
        Checker fromSpace = currentBoard[fromRow][fromCol]; // Gets the fromSpace at from position
        Checker toSpace = currentBoard[toRow][toCol]; // Gets the square the mouse clicked on

        final int difRow = Math.abs(toRow - fromRow);
        final int difCol = Math.abs(toCol - fromCol);

        // Validations of Capture Moves
        if (difCol == 2 && difRow == 2){
            isCapture = true;

            // Find the middle position that should contain the opponent piece
            int midRow = fromRow + (toRow - fromRow) / 2; // Gets coordinates of middle space for Row
            int midCol = fromCol + (toCol - fromCol) / 2; // Gets coordinates of middle space for Column
            Checker midSpace = currentBoard[midCol][midRow]; // Sets the calculated mid-section between move to variable.

            // Check if the middle piece belongs to the opponent
            if (midSpace.getColor().equals(player.getColor())) {
                throw new GameException("Cannot capture your own piece.");
            }

            // Check if there's a piece at the middle position
            if (midSpace == null) {
                throw new GameException("Invalid capture move. No piece to capture.");
            }
        }

        if (difCol > 2 || difRow > 2){
            throw new GameException("Pieces can only move one to two spaces diagonally.");
        }

        // Checks if move is diagonal (Must implement further checks if we implement multiple moves in one validation for multiple captures)
        if (fromCol == toCol){
            throw new GameException("Invalid move. You must move your pieces diagonally.");
        }

        // If player does not click on a checker when mouse event is called.
        if (fromSpace == null) {
            throw new GameException("You did not click on a checker.");
        }

        // Checks to see if destination is empty.
        if (toSpace != null) {
            throw new GameException("You must choose an empty spot.");
        }

        // Check if fromSpace belongs to the player
        if (!fromSpace.getColor().equals(player.getColor())) {
            throw new GameException("Cannot move opponent's fromSpace");
        }

        // Checks if the current fromSpace is moving to a valid position (within bounds)
        if (toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            throw new GameException("Invalid move. Position is out of bounds.");
        }

        // Ensures that the destination of a fromSpace is accordance with the allowed move direction.
        if (player.getColor().equals("Red") && !fromSpace.isKing() && toSpace != null && toRow > fromRow){
            throw new GameException("Invalid move. Non-Kinged Red pieces can only move up the board.");
        }

        // Ensures that the destination of a fromSpace is accordance with the allowed move direction.
        if (player.getColor().equals("Black") && !fromSpace.isKing() && toSpace != null && toRow < fromRow){
            throw new GameException("Invalid move. Non-Kinged Black pieces can only move up the board.");
        }


        return true;
    }

    // Method to move a checker from one position to another
    public void moveChecker(int fromRow, int fromCol, int toRow, int toCol, Board board) {
        Checker[][] checkerBoard = board.getBoard(); // Gets the current state of the board
        // Get the checker from source position
        Checker piece = checkerBoard[fromRow][fromCol];

        // Remove piece from source position (set to null)
        checkerBoard[fromRow][fromCol] = null;

        // Place piece at destination position
        checkerBoard[toRow][toCol] = piece;
    }

}
