package com.app;

import com.app.controllers.StageController;
import com.app.logic.ProductManagementSystem;
import javafx.application.Application;
import javafx.stage.Stage;

import com.app.gui.pages.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        ProductManagementSystem.start();

        stage.setTitle("Product Management");
        stage.setResizable(false);
        StageController.loadPage(stage, new EmptyPage());
    }

    public static void main(String[] args) {
        launch();
    }
}