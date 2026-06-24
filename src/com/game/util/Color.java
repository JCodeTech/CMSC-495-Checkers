package com.game.util;

/**
 * UMGC CMSC 495
 * Illustrates incremental program development
 * Class CheckerColor - Class that stores the information of what color a checker piece is.
 * @author Alexander Egan
 * Date: June 22, 2026
 * JavaJDK - 26
 */

// Comment (Joseph Romano) - We may not even need this class. We probably will handle the color as in the player / Checker class. Though rendering the actual color may require this class.
public class Color {

	String color;

	public Color(String color) {
		this.color = color;
	}

	public String toString() {
		return color;
	}

	public String getColor() {
		return color;
	}
}