/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.objects;

public class Board {

	private Checker[][] checkerPiece; // Checker Piece
	private BoardSquare[][] checkerBoard; // Piece of the board.
	public

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

		checkerPiece = new Checker[8][8];
		checkerBoard = new BoardSquare[8][8];

		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {

				if (validBoardSpaces[i][j] == 1) {
					checkerBoard[i][j] = new BoardSquare("Black", i, j);
					if (i < 3) {
						checkerPiece[i][j] = new Checker("Black", false, i, j);
					} else if (i >= 5) {
						checkerPiece[i][j] = new Checker("Red", false, i, j);
					}
				} else {
					checkerBoard[i][j] = new BoardSquare("White", i, j);
				}
			}
		}
	}

	// Function used for testing or possibly creating scenarios.
	public void setBoard(String color, boolean isKing, int row, int col, Checker[][] scenorioBoard){
		scenorioBoard[row][col] = new Checker(color, isKing, row, col);
	}

	// This will be used in the GUI implementation.
	// This returns the state of the board.
	// This will assist in rendering the board.
	// Can be used to check win / lose / draw conditions, but I may have a different way of doing that.
	public Checker[][] getCheckerPiece() {
		// Note: For now, this is acceptable to return the actual reference to the board.
		// However, if external methods modify the board, it will modify the actual board. So keep this in mind if this is our intention.
		// We may have to make a copy of the board and return that instead.
		// For now, this is fine.  All board modifications will be handled in this class.
		return checkerPiece;
	}

	public BoardSquare[][] getBoardPiece(){
		return checkerBoard;
	} // Returns the black and white squares on the board.

	// Whenever a checker is captured, this method will be called to clear that space.
	public void clearPosition(int row, int col) {
			checkerPiece[row][col] = null;
	}

	// Whenever a checker makes it to the opponents side.
	public void promoteToKing(int row, int col) {
		if (checkerPiece[row][col] != null && !checkerPiece[row][col].isKing()) {
			checkerPiece[row][col].setCheckerKing();
		}
	}

}