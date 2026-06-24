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

	// 1 represents a space a checker piece can be placed.
	// 0 represents a space that a checker piece cannot be placed.
	int[][] board = {
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
	};

	Checker[][] checkerBoard = new Checker[8][8];

	public Board(){
		setBoard();
	}

	//Sets the Checkerboard to a start of game state.
	// Black pieces are set at the top of the 2D array (rows 0-2).
	// Red pieces are set at the bottom of the 2D array (rows 5-7).
	public void setBoard() {
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				if (i % 2 == 0 && x % 2 == 0) {
					if (i < 3) {
						checkerBoard[i][x] = new Checker("Black");
					} else if (i > 4) {
						checkerBoard[i][x] = new Checker("Red");
					}
				}
				if (i % 2 == 1 && x % 2 == 1) {
					if (i < 3) {
						checkerBoard[i][x] = new Checker("Black");
					} else if (i > 4) {
						checkerBoard[i][x] = new Checker("Red");
					}
				}
			}
		}
	}

	public int[][] getBoard() {
		return board;
	}

}