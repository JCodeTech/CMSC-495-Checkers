package com.game.util;
/**
 * UMGC CMSC 495
 * Illustrates incremental program development
 * Class Checker - Class that stores the current state of the checkerboard. The board can be updated as needed.
 * @author Alexander Egan
 * Date: June 22, 2026
 * JavaJDK - 26
 */

import java.io.IOException;

public class GameException extends IOException{

    public GameException (String message) {
        super(message);
    }
}