package com.app.gui.components;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CustomText extends Text {
    public CustomText(String text, Color color, Font font) {
        setText(text);
        setFill(color);
        setFont(font);
    }

}
