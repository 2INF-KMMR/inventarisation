package com.app.gui.components;

import com.app.gui.nav.NavButtons;
import com.app.gui.nav.Sidebar;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Objects;

public class RootComponent extends HBox {
    String css = getResource("/style.css").toExternalForm();

    private URL getResource(String path) {
        return Objects.requireNonNull(getClass().getResource(path));
    }

    public RootComponent(Node page) {
        getStylesheets().add(css);
        getChildren().addAll(
            new Sidebar("OPTIONS", NavButtons.get()),
            page
        );
    }
}
