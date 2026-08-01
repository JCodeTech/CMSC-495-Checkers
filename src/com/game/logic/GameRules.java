package com.game.logic;/*
File name: GameRules.java
Description: This file handles all operations related to game conditions i.e. checking for valid moves, win / draw / lose conditions, 
 */

public class GameRules{

    public static int redCheckers = 0;
    public static int blackCheckers = 0;


    public static void isGameOver(){
        if (redCheckers == 0){
            System.out.println("Black Wins");
        }

        if (blackCheckers == 0){
            System.out.println("Red Wins");
        }

    }

}