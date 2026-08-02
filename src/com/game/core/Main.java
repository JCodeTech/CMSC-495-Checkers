package com.game.core;

import com.game.objects.Board;
import com.game.ui.BoardUI;
import com.game.ui.InfoPanel;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.game.entities.Player;


public class Main extends Application {

    public static Board board;
    public static BoardUI boardUI;

    @Override
    public void start(Stage primaryStage) {

        Window window = new Window();
        window.init(primaryStage);

        Pane root = window.getPane();

        Controller controller = new Controller();

        board = new Board();
        board.newGame();

        Player player1 = new Player("Player 1", "Red", true);
        Player player2 = new Player("Player 2", "Black", true);

        boardUI = new BoardUI(root, board);
        InfoPanel turnPanel = new InfoPanel();

        MainMenu mainMenu = new MainMenu();
        root.getChildren().add(mainMenu);
        root.getChildren().add(turnPanel);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Board getBoard(){
        return board;
    }

    public static BoardUI getBoardUI(){
        return boardUI;
    }
}
