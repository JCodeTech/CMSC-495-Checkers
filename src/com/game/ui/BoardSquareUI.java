package com.game.ui;

import com.game.objects.Board;
import com.game.objects.BoardSquare;
import com.game.objects.Checker;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardSquareUI {
    private Board board;
    private final BoardSquare boardSquare; // The Square object that this UI object will represent.
    private final Rectangle square; // UI representation of the Square.
    private final int row;
    private final int col;
    private static final int squareSize = 60; // Sizes of the board squares

    public BoardSquareUI(BoardSquare boardSquare, Board board, int row, int col){
        this.boardSquare = boardSquare;
        this.board = board;
        this.row = row;
        this.col = col;
        this.square = createSquare();

        square.setOnMouseClicked(event -> {
            // TODO: Implement Checker Object Linking
            System.out.println("TEST: The " + boardSquare.getColor() + " Square at position (" + row + ", " + col + ") has been clicked on.");
            BoardSquare selectedSpace = board.findSelected(boardSquare);
            if (selectedSpace != null) {
                System.out.println("Found selected object at " + selectedSpace.getRow() + ", " + selectedSpace.getCol());
                selectedSpace.setSelected(false);
            }
            boardSquare.setSelected(true);
        });
    }

    private Rectangle createSquare() {
        Rectangle square = new Rectangle();

        square.setHeight(squareSize);
        square.setWidth(squareSize);
        square.setX(col * squareSize);
        square.setY(row * squareSize);

        if ((row % 2 == 0 && col % 2 == 0) || (row % 2 == 1 && col % 2 == 1)) {
            square.setFill(Color.BLACK);
        } else {
            square.setFill(Color.WHITE);
        }

        return square;
    }

    public BoardSquare getBoardSquare() {
        return boardSquare;
    }

    public Rectangle getSquare() {
        return square;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}