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

    // TODO: Validate that source position contains a piece
    // TODO: Validate that the piece belongs to the current player
    // TODO: Validate that destination position is within board bounds
    // TODO: Validate that destination position is empty (no piece already there)
    // TODO: Validate correct move direction for king checker (forward and backward)
    // TODO: Validate single step move or capture move
    // TODO: Validate capture move logic (jumping over opponent piece)
    // TODO: Validate that pieces are actually captured and removed from board
    // TODO: Validate that a player must capture if possible

    public boolean validateMove(Board board, Player player) throws GameException {
        Checker[][] currentBoard = board.getBoard(); // Gets the current state of the board
        Checker piece = currentBoard[fromRow][fromCol]; // Gets the piece at from position

        // If player does not click on a checker when mouse event is called.
        if (currentBoard[fromRow][fromCol] == null) {
            throw new GameException("You did not click on a checker.");
        }

        // Check if piece belongs to the player
        if (!piece.getColor().equals(player.getColor())) {
            throw new GameException("Cannot move opponent's piece");
        }

        // Checks if the current piece is moving to a valid position (within bounds)
        if (toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
            throw new GameException("Invalid move. Position is out of bounds.");
        }
        if (player.getColor().equals("Red") && !piece.isKing() && currentBoard[toRow][toCol] != null && toRow > fromRow){
            throw new GameException("Invalid move. Non-Kinged Red pieces can only move up the board.");
        }

        if (player.getColor().equals("Black") && !piece.isKing() && currentBoard[toRow][toCol] != null && toRow < fromRow){
            throw new GameException("Invalid move. Non-Kinged Red pieces can only move up the board.");
        }

        return true;
    }
}
