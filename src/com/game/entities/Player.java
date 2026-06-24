package com.game.entities;
/*
CMSC 495 Computer Science Capstone
Group 2 (Joseph Romano, Alexander Egan, Pavel Parada)
File Author: Joseph Romano
Modified By (list):
* Joseph Romano
 */

public class Player {
    private String color; // "RED" or "BLACK"
    private int Pieces;

    public Player(String color) {
        this.color = color;
        this.Pieces = 12;
    }

    public void removePiece() {
        if (Pieces > 0) {
            Pieces--;
        }
    }

    public String getColor() {
        return color;
    }
}
