/**
 * UMGC CMSC 495
 * Developers: Alexander Egan, Joseph Romano
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.test;

import java.io.IOException;

import com.game.entities.Player;
import com.game.logic.Move;
import com.game.objects.Board;
import com.game.objects.Checker;
import com.game.util.GameException;

public class UnitTests {
	
	static Board board = new Board();
	static Player player = new Player("testPlay", "Black");

	public static void main(String[] args) throws IOException {
        System.out.println("Unit Test 1 (Checker Creation): " + UnitTest1());
        System.out.println("Unit Test 2 (Checker King Status): " + UnitTest2());
        System.out.println("Unit Test 3 (Board Initialization): " + UnitTest3());
        System.out.println("Unit Test 4 (Move Validation - Invalid Piece Movement Onto Other Piece): " + UnitTest4());
        System.out.println("Unit Test 5 (Move Validation - Invalid Piece Capture): " + UnitTest5());
        System.out.println("Unit Test 6 (Move Validation - Invalid Move Range): " + UnitTest6());
        System.out.println("Unit Test 7 (Move Validation - Invalid Vertical and Horizontal Move): " + UnitTest7());
        System.out.println("Unit Test 8 (Move Validation - Invalid Board Range): " + UnitTest8());
        System.out.println("Unit Test 9 (Move Validation - Invalid Piece Selection): " + UnitTest9());
        System.out.println("Unit Test 10 (Move Validation - Invalid Capture): " + UnitTest10());
        System.out.println("Unit Test 11 (Move Validation - Invalid Backwards Movement): " + UnitTest11());
        System.out.println("Unit Test 12 (Valid Capture): " + UnitTest12());
        System.out.println("Unit Test 13 (Valid Move): " + UnitTest13());
	}

    // Unit Test 1: Checker Class creates and stores information
    public static boolean UnitTest1() {
        try {
            Checker checker = new Checker("Black", false);
            
            if (checker.getColor().equals("Black") && !checker.isKing()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Unit Test 2: Checker Class handles king promotion
    public static boolean UnitTest2() {
        try {
            Checker checker = new Checker("Black", false);
            
            if (!checker.isKing()) {
                checker.setCheckerKing();
            }

            if (checker.isKing() && checker.getColor().equals("Black")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    // Unit Test 3: Board Class creates and sets the Checker Board
    public static boolean UnitTest3() {
        try {
            board = new Board();
            board.newGame();
            
            // Check that board is initialized with correct number of pieces
            Checker[][] boardState = board.getBoard();
            
            int blackPieces = 0;
            int redPieces = 0;
            
            // Count pieces on the board
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (boardState[i][j] != null) {
                        if (boardState[i][j].getColor().equals("Black")) {
                            blackPieces++;
                        } else if (boardState[i][j].getColor().equals("Red")) {
                            redPieces++;
                        }
                    }
                }
            }
            
            // Should have 12 black pieces and 12 red pieces
            return (blackPieces == 12 && redPieces == 12);
        } catch (Exception e) {
            System.out.println("Error in UnitTest3: " + e.getMessage());
            return false;
        }
    }
	
    // Unit Test 4: Checks logic for moving one piece onto another.
    public static boolean UnitTest4() {
    	Move move1 = new Move(0, 0, 1, 1);

		try {
			move1.validateMove(board, player);
			return false;
		} catch (GameException gE){
			System.out.println(gE);
			return true;
		}
    }
    
    // Unit Test 5: Checks logic for moving a piece as if it would capture a player's own piece.
    public static boolean UnitTest5() {

    			Move move2 = new Move(0,0,2,2);
    			try {
    				move2.validateMove(board, player);
    				return false;
    			} catch (GameException gE){
    				System.out.println(gE);
    				return true;
    			}    	
    }
    
    // Unit Test 6: Checks logic for attempting to move a piece more than 2 spaces.
    public static boolean UnitTest6() {
		Move move3 = new Move(0,0,4,4);
		try {
			move3.validateMove(board, player);
			return false;
		} catch (GameException gE){
			System.out.println(gE);
			return true;
		}
    }
    
    // Unit Test 7: Checks logic for vertical and horizontal movement.
    public static boolean UnitTest7() {
		// The validMove method does not check if a piece was attempted to be played in the same Row.
		// I recommend modifying the check for if a move is diagonal to include checking rows, as any 
		// piece that moves in Checkers changes rows and columns each time.
	
		Move move4 = new Move(0,0,0,1);
		Move move5 = new Move(0,0,1,0);
		try {
			move4.validateMove(board, player);
			move5.validateMove(board, player);
			return false;
		} catch (GameException gE){
			System.out.println(gE);
			return true;
		}
    }
    
    // Unit Test 8: Checks logic on how it handles values outside of the board's range.
    public static boolean UnitTest8() {
		// The validateMove method does not check variables before they are used for arrays.
		// I would recommend adding a check beforehand so that negative values are handled.
		// I do understand that this is somewhat of an edge case as with the UI negative numbers will 
		// be unachievable.

		Move move6 = new Move(0,0,-1,9);
		try {
			move6.validateMove(board, player);
			return false;
		} catch (Exception gE){
			System.out.println(gE);
			return true;
		}
    }
    
    // Unit Test 9: Checks logic on how it handles not selecting a checker for a move.
    public static boolean UnitTest9() {
		Move move7 = new Move(0,1,0,0);
		try {
			move7.validateMove(board, player);
			return false;
		} catch (Exception gE){
			System.out.println(gE);
			return true;
		}
    }
    
    // Unit Test 10: Checks logic for an attempted capturing move that is not possible.
    public static boolean UnitTest10() {
		// The validMove method has some dead code that prevents the error messages intended to be 
		// sent from being sent. This example shows that though a move completes the logic for 
		// midSpace == null, no message for invalid capture is shown, only not capturing your own piece.
		// I recommend changing the orders of these statements to reflect the specificity of them.

		Move move8 = new Move(2,0,4,2);
		try {
			move8.validateMove(board, player);
			return false;
		} catch (Exception gE){
			System.out.println(gE);
			return true;
		}
    }
    
    // Unit Test 11: Checks logic on moving a piece backwards.
    public static boolean UnitTest11() {
		// The following two checks have a similar problem to the one prior, where the
		// logic for checking for these things happening is never reached.
		// If the player's color is the same as the color of the piece they are moving,
		// They are able to move it backwards despite it not being kinged.

		board.setBoard("Red" , false, 3, 1, board.getBoard());
		board.setBoard("Black" , false, 4, 6, board.getBoard());
		Move move9 = new Move(3,1,4,2);
		Move move10 = new Move(4,6,3,7);
		try {
			move9.validateMove(board, player);
			move10.validateMove(board, player);
			return false;
		} catch (Exception gE){
			System.out.println(gE + " Red Piece");
			return true;
		}
    }
    
    // Unit Test 12: Check logic on valid capture.
    public static boolean UnitTest12() {
		Move move11 = new Move(2,0,4,2);
		try {
			move11.validateMove(board, player);
			return true;
		} catch (Exception gE){
			return false;
		}
    }
    
    // Unit Test 13: Checks logic for valid piece movement.
    public static boolean UnitTest13() {
    	Move move12 = new Move(2,2,3,3);
		try {
			move12.validateMove(board, player);
			return true;
		} catch (Exception gE){
			System.out.println(gE);
			return false;
		}
    }

}
