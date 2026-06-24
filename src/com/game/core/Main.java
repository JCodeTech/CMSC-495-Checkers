package com.game.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Window window = new Window();
        window.init(stage);
    }

    public static void main(String[] args) {

        launch(args);
    }
}