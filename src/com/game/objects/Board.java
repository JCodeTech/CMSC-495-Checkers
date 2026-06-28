package com.game.objects;

/**
 * UMGC CMSC 495
 * Illustrates incremental program development
 * Class Checker - Class that stores the current state of the checkerboard. The board can be updated as needed.
 * @author Alexander Egan
 * Date: June 22, 2026
 * JavaJDK - 26
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

	public Board(){
		setBoard();
	}

	//Sets the Checkerboard to a start of game state.
	// Black pieces are set at the top of the 2D array (rows 0-2).
	// Red pieces are set at the bottom of the 2D array (rows 5-7).
	public void setBoard() {
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

	public Checker[][] getBoard() {
		return checkerBoard;
	}

	// Whenever a checker is captured, this method will be called to clear that space.
	public void clearPosition(int row, int col) {
		if (row >= 0 && row < 8 && col >= 0 && col < 8) {
			checkerBoard[row][col] = null;
		}
	}

}