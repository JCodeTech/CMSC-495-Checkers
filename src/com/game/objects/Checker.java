package com.game.objects;

import java.awt.*;

/**
 * UMGC CMSC 495
 * Illustrates incremental program development
 * Class Checker - Class that stores information about a single piece on the checkerboard.
 * @author Alexander Egan
 * Date: June 22, 2026
 * JavaJDK - 26
 *
 * Modified By Romano, Joseph on 06/24/2026
 */

public class Checker {

	// Variables that this class will need
	private final String color;
	private boolean isKing = false;

	public Checker (String color, boolean isKing) {
		this.color = color;
		this.isKing = false; // All checkers start as regular pieces, not kings

	}

	public void setCheckerKing() {
		this.isKing= true; // Sets the checker to king status when called.
	}

	public boolean isKing() {
		return this.isKing; // Returns a boolean value based on if the checker is king or not.
	}

	public String getColor() {
		return this.color; // Returns the color of the checker.
	}

}
