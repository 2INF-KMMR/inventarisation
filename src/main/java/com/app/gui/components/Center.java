package com.app.gui.components;

import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class Center extends TilePane {
    public Center() {
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
        setAlignment(Pos.CENTER);
    }
}
