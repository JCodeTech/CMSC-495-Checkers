package com.game.core;

import com.game.objects.Board;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PauseMenu extends Pane {

    boolean visible = false;

    public PauseMenu() {

        setStyle("-fx-background-color: #C6C6C6");
        setOpacity(0.9);
        setPrefSize(800, 600);
        setVisible(false);

        // Game Title Label.
        Label checkersLabel = new Label("Checkers");
        checkersLabel.setPrefSize(250, 50);
        checkersLabel.setLayoutX(300);
        checkersLabel.setLayoutY(50);
        checkersLabel.isVisible();
        checkersLabel.setStyle("-fx-font: 50 arial");

        getChildren().add(checkersLabel);

        Button newGame = new Button("New Game");

        newGame.setOnAction(e -> {
            visible = false;
            Board.clearBoard();
            show();
        });

        newGame.setPrefSize(400, 50);
        newGame.setLayoutX(200);
        newGame.setLayoutY(300);
        newGame.setStyle("-fx-font: 30 arial");

        getChildren().add(newGame);

        Button resumeGame = new Button("Resume Game");

        resumeGame.setOnAction(e -> {

            visible = false;
            show();
        });

        resumeGame.setPrefSize(400, 50);
        resumeGame.setLayoutX(200);
        resumeGame.setLayoutY(400);
        resumeGame.setStyle("-fx-font: 30 arial");

        getChildren().add(resumeGame);

        Button quitGame = new Button("Quit Game");

        quitGame.setOnAction(e -> {
            System.exit(0);
        });

        quitGame.setPrefSize(400, 50);
        quitGame.setLayoutX(200);
        quitGame.setLayoutY(500);
        quitGame.setStyle("-fx-font: 30 arial");

        getChildren().add(quitGame);

    }

    public void toggleMenu() {
        if (Controller.gameStarted == true){
            setVisible(!isVisible());
            if (isVisible()) {
                toFront();
            }
        }
    }

    public void show(){this.setVisible(visible);}


}
