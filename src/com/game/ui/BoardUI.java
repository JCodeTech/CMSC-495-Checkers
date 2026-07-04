/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.ui;

import com.game.objects.Board;
import com.game.objects.Checker;
import com.game.logic.Move;
import com.game.entities.Player;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BoardUI {
    private final Pane root;
    private final CheckerUI[][] checkerUIs;
    private final Board board;
    private static final double CIRCLE_RADIUS = 20;
    private static final double SPACING = 60; // Space between circles
    private static final int squareSize = 60; // Sizes of the board squares

    public BoardUI(Pane root, Board board) {
        this.root = root;
        this.board = board;
        this.checkerUIs = new CheckerUI[8][8];
        
        initializeBoard();
    }
    
    private void initializeBoard() {
        Checker[][] checkerBoard = board.getBoard();
        
        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {

                Checker checker = checkerBoard[row][col];
                Rectangle square = new Rectangle();

                square.setHeight(squareSize);
                square.setWidth(squareSize);
                square.setX(col * squareSize);
                square.setY(row * squareSize);

                if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1)){
                    square.setFill(Color.BLACK);
                }
                else {
                    square.setFill(Color.WHITE);
                }
                root.getChildren().add(square);

                if (checker != null) {
                    // Create UI circle object
                    Circle circle = new Circle();
                    circle.setRadius(CIRCLE_RADIUS);
                    circle.setCenterX(col * SPACING + SPACING/2);
                    circle.setCenterY(row * SPACING + SPACING/2);

                    // Set color based on checker type
                    if (checker.getColor().equals("Red")) {
                        circle.setFill(Color.RED);
                    } else {
                        circle.setFill(Color.GRAY);
                    }

                    // Make king checkers slightly larger, might do something else with this.
                    if (checker.isKing()) {
                        circle.setRadius(CIRCLE_RADIUS + 5);
                    }
                    
                    // Links the checker to its circle UI
                    CheckerUI checkerUI = new CheckerUI(checker, circle, row, col);
                    checkerUIs[row][col] = checkerUI;
                    
                    // Add circle to the UI pane
                    root.getChildren().add(circle);
                }
            }
        }
    }

    // Getter method for the checker UI object.
    public CheckerUI getCheckerUI(int row, int col) {
        return checkerUIs[row][col];
    }

    // Updates UI once move has been initiated.
    public void handleUIMove(int fromRow, int fromCol, int toRow, int toCol, Player currentPlayer) {
        // This method is to be called after a move has been validated and checker object moved.
        // Can use the checkerUIs array to get the appropriate checker object
        CheckerUI fromCheckerUI = checkerUIs[fromRow][fromCol];
        if (fromCheckerUI != null) {
            // TODO: Link move logic
            System.out.println("Moving checker: " + fromCheckerUI.getChecker().getColor());

        }
    }
}