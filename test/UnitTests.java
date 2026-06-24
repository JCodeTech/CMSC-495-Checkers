
/**
 * UMGC CMSC 495
 * Illustrates incremental program development
 * Class Checker - Class that stores the current state of the checkerboard. The board can be updated as needed.
 * @author Alexander Egan
 * Date: June 22, 2026
 * JavaJDK - 26
 */

import com.game.objects.Board;
import com.game.objects.Checker;
import com.game.util.GameException;

import java.awt.*;
import java.io.IOException;

public class UnitTests {

    static Board board = new Board();

    static Checker[][] checkers = board.getCheckersPlacement();

    public static void main(String[] args) throws IOException {
        System.out.println("Unit Test 1: " + UnitTest1());
        System.out.println("Unit Test 2: " + UnitTest2());
        System.out.println("Unit Test 3: " + UnitTest3());
        System.out.println("Unit Test 4: " + UnitTest4());
        System.out.println("Unit Test 5: " + UnitTest5());
        System.out.println("Unit Test 6: " + UnitTest6());
    }

    // Unit Test 1: Color Class properly gives color when called.

    public static boolean UnitTest1() {
        Color color = new Color("Green");

        if (color.getColor().equals("Green") && ("" + color).equals("Green")){
            return true;
        } else
            return false;
    }

    // Unit Test 2: Checker Class stores information about its current state and can be changed.

    public static boolean UnitTest2() {
        Checker checker = new Checker("Black");

        if (checker.isKing() == false) {
            checker.checkerKing();
        }

        if (checker.isKing() == true && checker.getColor().equals("Black")) {
            return true;
        } else return false;
    }

    // Unit Test 3: Board Class properly creates and sets the Checker Board.

    public static boolean UnitTest3() {
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int x = 0; x < 8; x++) {
                System.out.print(checkers[i][x] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        return true;
    }

    // Unit Test 4: Board Class "moveChecker" method updates the checker board data
    // and does not have any duplicating pieces.

    public static boolean UnitTest4() {
        try {
            board.setBoard();
            board.moveChecker(2, 0, 3, 1);
            board.moveChecker(5, 1, 4, 2);
        } catch (GameException GE) {
            return false;
        }

        if (checkers[2][0] == null && checkers[3][1].getColor().equals("Black") && checkers[5][1] == null
                && checkers[4][2].getColor().equals("Red")) {
            return true;
        } else
            return false;
    }
    // Unit Test 5: Board Class "moveChecker" only allows movement within Checker's
    // rules

    public static boolean UnitTest5() {
        try {
            board.setBoard();
            board.moveChecker(2, 0, 5, 3);
        } catch (GameException GE) {
            System.out.println(GE);
        }
        if (checkers[5][3].getColor().equals("Black")) {
            return false;
        } else
            return true;
    }

    // Unit Test 6: GameException thrown if invalid move is made.
    public static boolean UnitTest6() {
        try {
            board.moveChecker(2, 0, 5, 4);
        } catch (GameException GE) {
            System.out.println(GE);
            return true;
        }
        return false;
    }

}