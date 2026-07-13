/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.objects;


public class Checker {

	// Variables that this class will need
	private final String color;
	private boolean isKing;
	private int row;
	private int col;

	public Checker (String color, boolean isKing, int row, int col) {
		this.color = color;
		this.isKing = false; // All checkers start as regular pieces, not kings
		this.row = row;
		this.col = col;

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
