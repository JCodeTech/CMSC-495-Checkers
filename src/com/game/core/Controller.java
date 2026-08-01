package com.game.core;

import com.game.ui.InfoPanel;


public class Controller{

    public static boolean player1Turn = true;
    public static boolean playerVsPlayer = true;
    public static boolean gameStarted = false;


public static void flipTurn(){
    if (player1Turn){
        InfoPanel.setTurn("Black");
    }
    else{
        InfoPanel.setTurn("Red");
    }
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
