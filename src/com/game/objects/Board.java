/**
 * UMGC CMSC 495
 * Developers: Joseph Romano, Alexander Egan
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.objects;

import com.game.logic.GameRules;

import java.util.Objects;

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
						GameRules.blackCheckers++;
					} else if (i >= 5) {
						checkerPiece[i][j] = new Checker("Red", false, i, j);
						GameRules.redCheckers++;
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

	public Checker[][] getCheckerPiece() {
		return checkerPiece;
	}

	public BoardSquare[][] getBoardPiece(){
		return checkerBoard;
	} // Returns the black and white squares on the board.

	// Whenever a checker is captured, this method will be called to clear that space.
	public void clearPosition(int row, int col, boolean isCapture) {

		if (isCapture) {
			Checker cPiece = checkerPiece[row][col];
			if (cPiece.getColor().equals("Red")) {
				GameRules.redCheckers--;
				System.out.println(GameRules.redCheckers);
				GameRules.isGameOver();
			} else {
				GameRules.blackCheckers--;
				System.out.println(GameRules.blackCheckers);
				GameRules.isGameOver();
			}
		}
		checkerPiece[row][col] = null;
		//cPiece = null;
	}

	// Whenever a checker makes it to the opponents side.
	public void promoteToKing(int row, int col) {
		if (checkerPiece[row][col] != null && !checkerPiece[row][col].isKing()) {
			checkerPiece[row][col].setCheckerKing();
		}
	}

	public Checker findSelectedChecker(Checker selectedChecker){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (checkerPiece[i][j] != null && checkerPiece[i][j].getSelected() && checkerPiece[i][j] == selectedChecker){
					return selectedChecker;
				}
			}
		}
		return null;
	}

	public BoardSquare findSelectedSpace(BoardSquare selectedSpace){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (checkerBoard[i][j] != null && checkerBoard[i][j].getSelected() && checkerBoard[i][j] == selectedSpace){
					return selectedSpace;
				}
			}
		}
		return null;
	}

	public Object findSelected(String type){

		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){

				if (Objects.equals(type, "space")
						&& checkerBoard[i][j] != null
						&& checkerBoard[i][j].getSelected()){

					return checkerBoard[i][j];
				}

				if (Objects.equals(type, "checker")
						&& checkerPiece[i][j] != null
						&& checkerPiece[i][j].getSelected()){

					return checkerPiece[i][j];
				}
			}
		}

		return null;
	}

	public void clearSelectedCheckers() {
		for (Checker[] row : checkerPiece) {
			for (Checker checker : row) {
				if (checker != null) {
					checker.setSelected(false);
				}
			}
		}
	}

}