package com.app.controllers.button_controller;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public abstract class ButtonController {
    Button button;

    public ButtonController(Button _button) {
        button = _button;
    }

    public void onClick(MouseEvent event) {

    }
}
