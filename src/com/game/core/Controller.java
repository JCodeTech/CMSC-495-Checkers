package com.game.core;

import com.game.logic.AILogic;
import com.game.ui.InfoPanel;
import com.game.util.GameException;


public class Controller{

    public static boolean player1Turn = true;
    public static boolean playerVsPlayer = true;
    public static boolean gameStarted = false;


public static void flipTurn() throws GameException {

    player1Turn = !player1Turn;
    System.out.println("It is now " + (player1Turn ? "Player 1's Turn." : "Player 2's Turn."));
    if (player1Turn){
        InfoPanel.setTurn("Red");
    }
    else{
        InfoPanel.setTurn("Black");
        if (!playerVsPlayer){
            AILogic.AITurn();
        }
    }

}

public static void setGameMode(boolean gameMode){
    playerVsPlayer = gameMode;
    System.out.println("Player vs Player variable is set to: " + gameMode);
}

public static boolean getPlayerTurn(){
    return player1Turn;
}

}
