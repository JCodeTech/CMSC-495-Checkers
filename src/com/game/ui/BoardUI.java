/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.ui;

import com.game.objects.Board;
import com.game.objects.Checker;
import com.game.objects.BoardSquare;
import javafx.scene.layout.Pane;

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
                BoardSquareUI boardSquareUI = new BoardSquareUI(square, row, col);
                boardSquareUIS[row][col] = boardSquareUI;
                root.getChildren().add(boardSquareUI.getSquare());
            }
        }
    }

    public void updateCheckerPieceUI(){
        Checker[][] checkerPiece = board.getCheckerPiece();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Checker checker = checkerPiece[row][col];
                if (checker != null) {
                    // Create UI checker object with its circle
                    CheckerUI checkerUI = new CheckerUI(checker, row, col);
                    checkerUIs[row][col] = checkerUI;

                    // Add circle to the UI pane
                    root.getChildren().add(checkerUI.getCircle());
                }
            }
        }
    }



    // Getter method for the checker UI object.
    public CheckerUI getCheckerUI(int row, int col) {
        return checkerUIs[row][col];
    }
}