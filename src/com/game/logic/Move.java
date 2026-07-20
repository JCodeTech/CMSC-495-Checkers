/**
 * UMGC CMSC 495
 * Developers: Joseph Romano
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.logic;

import com.game.objects.Board;
import com.game.objects.BoardSquare;
import com.game.objects.Checker;
import com.game.ui.BoardUI;
import com.game.util.GameException;

public class Move {
    private final Board board;
    private final BoardUI boardUI;
    private final MoveValidation moveValidation;

    public Move(Board board, BoardUI boardUI) {
        this.board = board;
        this.boardUI = boardUI;
        this.moveValidation = new MoveValidation(board);
    }

    public void makeMove() throws GameException {
        BoardSquare destination = (BoardSquare) board.findSelected("space");
        Checker piece = (Checker) board.findSelected("checker");

        moveValidation.validateMove(piece, destination);

        int fromRow = piece.getRow();
        int fromCol = piece.getCol();
        int toRow = destination.getRow();
        int toCol = destination.getCol();

        if (Math.abs(toRow - fromRow) == 2 && Math.abs(toCol - fromCol) == 2) {
            int capturedRow = (fromRow + toRow) / 2;
            int capturedCol = (fromCol + toCol) / 2;
            board.clearPosition(capturedRow, capturedCol);
        }

        board.clearPosition(fromRow, fromCol);
        board.getCheckerPiece()[toRow][toCol] = piece;
        piece.setNewPos(toRow, toCol);

        if (toRow == 0 || toRow == 7) {
            board.promoteToKing(toRow, toCol);
        }

        piece.setSelected(false);
        destination.setSelected(false);

        boardUI.updateCheckerPieceUI();
    }
}