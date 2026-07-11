package com.game.core;

import com.game.objects.Board;
import com.game.ui.BoardUI;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

	        Window window = new Window();
	        window.init(primaryStage);
	
	        Board board = new Board();
	        board.newGame();
	
	        BoardUI boardUI = new BoardUI(window.getPane(), board);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
