/*
File name: Window.java
Description: This file handles all operations related to rendering the window.
 */

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

class Window{
    public Window(){
        gamePane = new Pane();
        gamePane.setPrefSize(800, 800);
        drawBoard(gamePane);
        scene = new Scene(gamePane, 800, 800);
    }
}