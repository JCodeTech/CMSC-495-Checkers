/**
 * UMGC CMSC 495
 * Illustrates incremental program development
 * Class Checker - Class that stores information about a single piece on the checkerboard.
 * @author Alexander Egan
 * Date: June 22, 2026
 * JavaJDK - 26
 */

public class Checker {

	private boolean isKing = false;
	private Color color;

	public Checker (String color) {
		this.color = new Color(color);
	}

	public void checkerKing() {
		isKing = true;
	}

	public boolean isKing() {
		return isKing;
	}

	public String getColor() {
		return color.getColor();
	}

	public String toString() {
		return "" + color;
	}
}