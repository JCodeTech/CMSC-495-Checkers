package com.game.objects;

public class BoardSquare {

    // Variables that this class will need
    private final String color;
    private int row;
    private int col;

    public BoardSquare (String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;

    }

    public int getRow() {return this.row;}

    public int getCol() {return this.col;}

    public String getColor() {return this.color;}

}
