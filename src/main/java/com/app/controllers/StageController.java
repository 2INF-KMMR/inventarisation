package com.app.controllers;

import com.app.gui.components.RootComponent;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageController {
    public static Stage currentStage;
    static public Stage eventToStage(Event event){
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }
    static public void loadPage(Stage stage, Node page) {
        currentStage = stage;
        var root = new RootComponent(page);
        var scene = new Scene(root, 800, 600);

        stage.setScene(scene);
        stage.show();
    }
}
