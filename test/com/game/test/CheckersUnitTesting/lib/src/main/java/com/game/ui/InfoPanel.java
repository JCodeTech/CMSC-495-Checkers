package com.game.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class InfoPanel extends Pane {

    private static Label turnLable;

    public InfoPanel(){
        turnLable = new Label("Red's Turn");
        turnLable.setPrefSize(100,100);
        turnLable.setLayoutX(600);
        turnLable.setLayoutY(0);
        setMouseTransparent(true);
        getChildren().add(turnLable);
    }

    public static void setTurn(String turn){
        turnLable.setText(turn + "'s Turn");
    }

}
