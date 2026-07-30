package com.game.core;

import java.awt.event.KeyEvent;

public class Controller{

    public static boolean player1Turn = true;
    public static boolean playerVsPlayer = true;
    public static boolean gameStarted = false;

public static void flipTurn(){

    player1Turn = !player1Turn;
    System.out.println("It is now " + (player1Turn ? "Player 1's Turn." : "Player 2's Turn."));
}

public static void setGameMode(boolean gameMode){
    playerVsPlayer = gameMode;
    System.out.println("Player vs Player variable is set to: " + gameMode);
}

public static boolean getPlayerTurn(){
    return player1Turn;
}

}
