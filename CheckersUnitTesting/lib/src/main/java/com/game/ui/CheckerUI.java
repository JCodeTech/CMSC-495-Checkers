/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: July 2026
 * JavaJDK - 26
 */

package com.game.ui;

import com.game.objects.Checker;
import javafx.scene.shape.Circle;

public class CheckerUI {
    private final Checker checker;
    private final Circle circle;
    private final int row;
    private final int col;
    
    public CheckerUI(Checker checker, Circle circle, int row, int col) {
        this.checker = checker;
        this.circle = circle;
        this.row = row;
        this.col = col;
        
        // Click handler to reference this specific checker UI object.
        circle.setOnMouseClicked(event -> {
            // TODO: Implement Checker Object Linking
            System.out.println("TESTING: Checker at position (" + row + ", " + col + ") has been clicked on.");
        });
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