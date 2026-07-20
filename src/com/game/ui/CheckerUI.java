/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.ui;

import com.game.objects.Board;
import com.game.objects.Checker;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class CheckerUI {
    private Board board;
    private final Checker checker;
    private final Circle circle;
    private final int row;
    private final int col;
    private static final double SPACING = 60; // Space between circles
    private static final double CIRCLE_RADIUS = 20;

    
    public CheckerUI(Checker checker, Board board, int row, int col) {
        this.checker = checker;
        this.board = board;
        this.row = row;
        this.col = col;

        this.circle = createCircle();

        // Click handler to reference this specific checker UI object.
        circle.setOnMouseClicked(event -> {
            System.out.println("TEST: The " + checker.getColor() + " Checker at position (" + row + ", " + col + ") has been clicked on.");
            Checker selectedChecker = board.findSelectedChecker(checker);
            if (selectedChecker != null) {
                System.out.println("Found selected object at " + selectedChecker.getRow() + ", " + selectedChecker.getCol());
                selectedChecker.setSelected(false);
            }
            checker.setSelected(true);
        });
    }

    private Circle createCircle() {
        Circle circle = new Circle();
        circle.setRadius(getCircleRadius());
        circle.setCenterX(col * SPACING + (SPACING/2));
        circle.setCenterY(row * SPACING + (SPACING/2));

        // Set color based on checker type
        if (checker.getColor().equals("Red")) {
            circle.setFill(Color.RED);
        } else {
            circle.setFill(Color.GRAY);
        }

        return circle;
    }

    private double getCircleRadius() {
        return checker.isKing() ? 25 : CIRCLE_RADIUS;
    }

    public Checker getChecker() {
        return checker;
    }

    public Circle getCircle() {
        return circle;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}