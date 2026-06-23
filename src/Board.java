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
	
	// moveChecker: A checker piece at a specific location can be moved to another valid location.
	// A valid location to move is marked by a one in the 2D array board.
	public void moveChecker(int pieceRow, int pieceColumn, int destinationRow, int destinationColumn) 
		throws GameException{
		Checker currentChecker = checkerBoard[pieceRow][pieceColumn];
		
		if (currentChecker != null && board[destinationRow][destinationColumn] == 1) {
			checkerBoard[destinationRow][destinationColumn] = currentChecker;
			checkerBoard[pieceRow][pieceColumn] = null;
		} else {
			throw new GameException("Cannot move Checker piece to invalid location or checker piece does not exist.");
		}
	}
	
	
	// Makes a checker piece into a king piece.
	public void checkerKing(int pieceRow, int pieceColumn) {
		checkerBoard[pieceRow][pieceColumn].checkerKing();
	}
	
	public Checker getTile(int row, int column) {
		return checkerBoard[row][column];
	}
	
	public int[][] getBoard() {
		return board;
	}
	
	public Checker[][] getCheckersPlacement(){
		return checkerBoard;
	}
}
