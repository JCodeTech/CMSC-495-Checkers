package com.game.objects;

/**
 * UMGC CMSC 495 Illustrates incremental program development Class Checker -
 * Class that stores the current state of the checkerboard. The board can be
 * updated as needed.
 * 
 * @author Alexander Egan Date: June 22, 2026 JavaJDK - 26
 */

public class Board {

	private Checker[][] checkerBoard;

	// 1 represents a space a checker piece can be placed.
	// 0 represents a space that a checker piece cannot be placed.
	int[][] validBoardSpaces = {
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
	};

	// This will be called in main or controller class to set up the board.
	// DO NOT CREATE BOARD OBJECTS WITHIN OTHER GAME OBJECTS.
	// This will only be ran once per game.
	public Board(){
		// Set board will be handled separately instead of being called automatically as soon as a board object is created.
	}

	//Sets the Checkerboard to a start of game state.
	// Black pieces are set at the top of the 2D array (rows 0-2).
	// Red pieces are set at the bottom of the 2D array (rows 5-7).
	public void newGame() { // Renamed function to newGame from setBoard. setBoard() will be used to set up certain test cases.
		checkerBoard = new Checker[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if (validBoardSpaces[i][j] == 1) {
					if (i < 3) {
						checkerBoard[i][j] = new Checker("Black", false);
					} else if (i >= 5) {
						checkerBoard[i][j] = new Checker("Red", false);
					}
				}
			}
		}
	}

	// Function used for testing or possibly creating scenarios.
	public void setBoard(String color, boolean isKing, int row, int col, Checker[][] scenorioBoard){
		scenorioBoard[row][col] = new Checker(color, isKing);
	}

	// This will be used in the GUI implementation.
	// This returns the state of the board.
	// This will assist in rendering the board.
	// Can be used to check win / lose / draw conditions, but I may have a different way of doing that.
	public Checker[][] getBoard() {
		// Note: For now, this is acceptable to return the actual reference to the board.
		// However, if external methods modify the board, it will modify the actual board. So keep this in mind if this is our intention.
		// We may have to make a copy of the board and return that instead.
		// For now, this is fine.  All board modifications will be handled in this class.
		return checkerBoard;
	}

	// Whenever a checker is captured, this method will be called to clear that space.
	public void clearPosition(int row, int col) {
		if (row >= 0 && row < 8 && col >= 0 && col < 8) {
			checkerBoard[row][col] = null;
		}
	}

	// Whenever a checker makes it to the opponents side.
	public void promoteToKing(int row, int col) {
		if (checkerBoard[row][col] != null) {
			checkerBoard[row][col].setCheckerKing();
		}
	}

}