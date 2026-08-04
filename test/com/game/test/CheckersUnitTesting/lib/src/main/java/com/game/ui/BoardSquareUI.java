package com.game.ui;

import com.game.logic.Move;
import com.game.objects.Board;
import com.game.objects.BoardSquare;
import com.game.util.GameException;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardSquareUI {
    private final Board board;
    private final BoardSquare boardSquare;
    private final Rectangle square;
    private final int row;
    private final int col;
    private static final int squareSize = 60;
    private final Move move;

    public BoardSquareUI(
            BoardSquare boardSquare,
            Board board,
            BoardUI boardUI,
            int row,
            int col) {

        this.boardSquare = boardSquare;
        this.board = board;
        this.row = row;
        this.col = col;
        this.square = createSquare();
        this.move = new Move(board, boardUI);

        square.setOnMouseClicked(event -> {
            BoardSquare previouslySelected =
                    (BoardSquare) board.findSelected("space");

            if (previouslySelected != null) {
                previouslySelected.setSelected(false);
            }

            boardSquare.setSelected(true);

            try {
                move.humanMove();
            } catch (GameException e) {
                boardSquare.setSelected(false);
                System.err.println(e.getMessage());
            }
        });
    }

    private Rectangle createSquare() {
        Rectangle square = new Rectangle();

        square.setHeight(squareSize);
        square.setWidth(squareSize);
        square.setX(col * squareSize);
        square.setY(row * squareSize);

        if ((row % 2 == 0 && col % 2 == 0)
                || (row % 2 == 1 && col % 2 == 1)) {
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