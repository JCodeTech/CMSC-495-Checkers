/**
 * UMGC CMSC 495
 * Developers: Alexander Egan
 * Modified by: Joseph Romano
 * Date: June 2026
 * JavaJDK - 26
 */

package com.game.core;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class MainMenu extends Pane {
    
    public MainMenu() {

    	setStyle("-fx-background-color: #C6C6C6");
    	setOpacity(0.9);
    	setPrefSize(800, 600);
    	
    	// Game Title Label.
    	Label checkersLabel = new Label("Checkers");
    	checkersLabel.setPrefSize(250, 50);
    	checkersLabel.setLayoutX(300);
    	checkersLabel.setLayoutY(50);
    	checkersLabel.isVisible();
    	checkersLabel.setStyle("-fx-font: 50 arial");
    	
    	getChildren().add(checkersLabel);
    	
    	Button playerStart = new Button("Player vs Player");
    	
    	playerStart.setOnAction(e -> {
    		// Put the method that will set the game to have player opponent here.
    		Controller.setGameMode(true); // sets the gamemode boolean variable in Controller class to true
    		hide();
    		});
    	
    	playerStart.setPrefSize(400, 50);
    	playerStart.setLayoutX(200);
    	playerStart.setLayoutY(300);
    	playerStart.setStyle("-fx-font: 30 arial");
    	
    	getChildren().add(playerStart);
    	
    	Button computerStart = new Button("Player vs Computer");
    	
    	computerStart.setOnAction(e -> {
    		// Put the method that will set the game to have computer opponent here.
			Controller.setGameMode(false); // sets the gamemode boolean variable in Controller class to false
    		hide();
    		});
    	
    	computerStart.setPrefSize(400, 50);
    	computerStart.setLayoutX(200);
    	computerStart.setLayoutY(400);
    	computerStart.setStyle("-fx-font: 30 arial");
    	
    	getChildren().add(computerStart);
    }

	public void show(){this.setVisible(true);}
    
    public void hide() {
    	this.setVisible(false);
    }
}
