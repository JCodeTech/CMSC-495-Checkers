/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.ui;

import com.game.objects.Board;
import com.game.objects.BoardSquare;
import com.game.objects.Checker;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

public class BoardUI {
    private final Pane root;
    private final CheckerUI[][] checkerUIs;
    private final BoardSquareUI[][] boardSquareUIS;
    private final Board board;

    public BoardUI(Pane root, Board board) {
        this.root = root;
        this.board = board;
        this.checkerUIs = new CheckerUI[8][8];
        this.boardSquareUIS = new BoardSquareUI[8][8];

        updateBoardUI();
        updateCheckerPieceUI();
    }

    private void updateBoardUI() {
        BoardSquare[][] checkerBoard = board.getBoardPiece();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                BoardSquare square = checkerBoard[row][col];
                BoardSquareUI boardSquareUI =
                        new BoardSquareUI(square, board, this, row, col);

                boardSquareUIS[row][col] = boardSquareUI;
                root.getChildren().add(boardSquareUI.getSquare());
            }
        }
    }

    public void updateCheckerPieceUI() {
        root.getChildren().removeIf(node -> node instanceof Circle);

        Checker[][] checkerPieces = board.getCheckerPiece();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                checkerUIs[row][col] = null;

                Checker checker = checkerPieces[row][col];
                if (checker != null) {
                    CheckerUI checkerUI = new CheckerUI(checker, board, row, col);
                    checkerUIs[row][col] = checkerUI;
                    root.getChildren().add(checkerUI.getCircle());
                }
            }
        }
    }

    public void showGameOverScreen(String winner) {
        root.getChildren().removeIf(node -> node instanceof GameOverScreen);
        GameOverScreen gameOverScreen = new GameOverScreen(winner);
        root.getChildren().add(gameOverScreen);
        gameOverScreen.toFront();
    }

    public CheckerUI getCheckerUI(int row, int col) {
        return checkerUIs[row][col];
    }
}