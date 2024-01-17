package com.app.gui.nav;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class Sidebar extends VBox {
    public Sidebar(String title, Node[] children){
        getStyleClass().add("sidebar");
        getChildren().addAll(
            new Label(title){{getStyleClass().add("nav-title-container");}},
            new Separator()
        );
        getChildren().addAll(children);
    }
}
