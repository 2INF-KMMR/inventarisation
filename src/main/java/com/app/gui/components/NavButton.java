package com.app.gui.components;

import com.app.controllers.button_controller.ButtonController;
import com.app.gui.utils.Fonts;
import javafx.scene.control.Button;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class NavButton extends Button {
    ArrayList<Runnable> onclickList = new ArrayList<>();
    ButtonController controller;

    public NavButton(String text, Runnable onclick) {
        getStyleClass().add("nav-button");
        setText(text);
        setMaxWidth(Double.MAX_VALUE);
        setOnMousePressed(e -> {
            highlight();
            onclick.run();
            for (var x : onclickList) x.run();
            if (controller != null)
                controller.onClick(e);
        });
        setFont(
            Fonts.select(
                Fonts.inter,
                FontWeight.NORMAL,
                12
            ));
    }

    public void setController(ButtonController _controller) {
        controller = _controller;
    }

    public void highlight() {
        if (!getStyleClass().contains("nav-button-clicked")) {
            getStyleClass().add("nav-button-clicked");
            setFont(Fonts.select(Fonts.inter, FontWeight.EXTRA_BOLD, 12));
        }

    }

    public void lowlight() {
        getStyleClass().remove("nav-button-clicked");
        setFont(Fonts.select(Fonts.inter, FontWeight.NORMAL, 12));
    }
}