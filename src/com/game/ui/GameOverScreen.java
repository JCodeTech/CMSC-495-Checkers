package com.game.ui;

import javafx.scene.layout.Pane;

public class GameOverScreen extends Pane{
    public GameOverScreen(String winner) {
        setStyle("-fx-background-color: #C6C6C6");
        setOpacity(0.9);
        setPrefSize(800, 600);

        // Game Over Label.
        javafx.scene.control.Label gameOverLabel = new javafx.scene.control.Label("Game Over");
        gameOverLabel.setPrefSize(250, 250);
        gameOverLabel.setLayoutX(300);
        gameOverLabel.setLayoutY(50);
        gameOverLabel.isVisible();
        gameOverLabel.setStyle("-fx-font: 50 arial");
        gameOverLabel.toFront();
        gameOverLabel.setMouseTransparent(false);

        getChildren().add(gameOverLabel);

        // Winner Label.
        javafx.scene.control.Label winnerLabel = new javafx.scene.control.Label(winner + " Wins!");
        winnerLabel.setPrefSize(250, 50);
        winnerLabel.setLayoutX(300);
        winnerLabel.setLayoutY(150);
        winnerLabel.isVisible();
        winnerLabel.setStyle("-fx-font: 30 arial");
        winnerLabel.toFront();
        winnerLabel.setMouseTransparent(false);

        getChildren().add(winnerLabel);
    } {

}}
