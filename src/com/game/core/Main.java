package com.game.core;

import com.game.objects.Board;
import com.game.ui.BoardUI;
import javafx.application.Application;
import javafx.stage.Stage;
import com.game.entities.Player;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Window window = new Window();
        window.init(primaryStage);

        Board board = new Board();
        board.newGame();
        Player player1 = new Player("Player 1", "Red", true);
        Player player2 = new Player("Player 2", "Black", true);


        BoardUI boardUI = new BoardUI(window.getPane(), board);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
