/**
 * UMGC CMSC 495
 * Developers: Joseph Romano
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.entities;

public class Player {
    private String name; // Player's name
    private String color; // "RED" or "BLACK"
    private int Pieces;
    private boolean isHuman; // true if human player, false if AI player

    public Player(String playerName, String color) {
        this.name = "Player"; // Default name, will be changed when a new player is created. i.e. "Player " + 1 or 2
        this.color = color; // Red or Black
        this.Pieces = 0; // When the board is set up the count is handled in that class via Player player1.addChecker.
    }

    // Used to remove a checker from total checker count for that player when captured.
    public void removeChecker() {
        if (Pieces > 0) {
            Pieces--;
        }
    }

    // Used during board set up to add to the player counter.
    public void addChecker(){
        Pieces++;
    }

    // Used for capture validation (Maybe handled in the checker class) Though we can use this for side / turn validation.
    public String getColor() {
        return color;
    }

    // Gets player's name
    public String getPlayerName(){
        return name;
    }
}
