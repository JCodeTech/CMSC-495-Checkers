package com.game.logic;/*
File name: GameRules.java
Description: This file handles all operations related to game conditions i.e. checking for valid moves, win / draw / lose conditions, 
 */

import com.game.core.Main;
import com.game.ui.GameOverScreen;

public class GameRules{

    public static int redCheckers = 0;
    public static int blackCheckers = 0;
    public static GameOverScreen gameOver;


    public static void isGameOver(){
        if (redCheckers == 0){
            System.out.println("Black Wins");
            gameOver = new GameOverScreen("Black");
            if (Main.getBoardUI() != null) {
                Main.getBoardUI().showGameOverScreen("Black");
            }


        }

        if (blackCheckers == 0){
            System.out.println("Red Wins");
            gameOver = new GameOverScreen("Red");
            if (Main.getBoardUI() != null) {
                Main.getBoardUI().showGameOverScreen("Red");
            }
        }

    }

}