package com.game.core;
/*
File name: Window.java
Description: This file handles all operations related to rendering the window.
 */

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Window {
    private Stage stage;
    private Pane gamePane;
    private Scene scene;

    public void init(Stage primaryStage) {
        this.stage = primaryStage;
        createUI();
    }

    private void createUI() {
        gamePane = new Pane();
        scene = new Scene(gamePane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public Pane getPane() {
        return gamePane;
    }
}