/**
 * UMGC CMSC 495
 * Unit Tests
 * @author Alexander Egan, Joseph Romano
 * Date: June 2026
 * JavaJDK - 26
 */

import com.game.logic.Move;
import com.game.objects.Board;
import com.game.objects.Checker;
import com.game.util.GameException;
import com.game.entities.Player;

public class UnitTests {

    static Board board = new Board();

    public static void main(String[] args) throws GameException {
        System.out.println("Unit Test 1 (Checker Creation): " + UnitTest1());
        System.out.println("Unit Test 2 (Checker King Status): " + UnitTest2());
        System.out.println("Unit Test 3 (Board Initialization): " + UnitTest3());
        System.out.println("Unit Test 4 (Move Validation - Valid): " + UnitTest4());
        System.out.println("Unit Test 5 (Move Validation - Invalid): " + UnitTest5());
        System.out.println("Unit Test 6 (Capture Logic): " + UnitTest6());
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

    // Unit Test 4: Valid Move validation - Valid move should pass
    public static boolean UnitTest4() {
        try {
            board = new Board();
            board.newGame();
            
            // Create a valid move (black piece moving diagonally)
            Move move = new Move(1, 1, 2, 0);
            Player player = new Player("TestPlayer", "Black");

            move.validateMove(board, player);

            // TODO: Finish implementation.
            Checker[][] testBoard = new Checker[8][8];
            //board.setBoard();

            // The move should be valid and not throw an exception
            return true;
            
        } catch (Exception e) {
            System.out.println("Error in UnitTest4: " + e.getMessage());
            return false;
        }
    }

    // Unit Test 5: Move validation - Invalid move should throw exception
    public static boolean UnitTest5() throws GameException {
        try {
            board = new Board(); // Reset board
            board.newGame(); // Sets up Board.
            
            // Try to make an invalid move
            Move move = new Move(2, 1, 4, 1); // Invalid - not diagonal
            Player player = new Player("TestPlayer", "Black");

            // Should throw GameException for invalid moves
            return false;
            
        } catch (Exception e) {
            System.out.println("Error in UnitTest5: " + e.getMessage());
            return false;
        }
    }

    // Unit Test 6: Capture logic validation
    public static boolean UnitTest6() {
        try {
            board = new Board();
            board.newGame();

            return true;
            
        } catch (Exception e) {
            System.out.println("Error in UnitTest6: " + e.getMessage());
            return false;
        }
    }

}