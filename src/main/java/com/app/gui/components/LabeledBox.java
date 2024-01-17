package com.app.gui.components;

import com.app.gui.utils.Fonts;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;

public class LabeledBox extends VBox {
    private TextArea textArea;
    public TextArea getTextArea(){
        return textArea;
    }

    public LabeledBox(double width, String title, String content) {
        Label label = new Label(title);
        label.setPrefHeight(50);
        label.setWrapText(true);
        label.setFont(Fonts.select(Fonts.inter, FontWeight.BLACK, 12));
        label.getStyleClass().add("box-label");
        label.setPadding(new Insets(10.0));
        label.setPrefWidth(width);

        textArea = new TextArea(content);
        textArea.setPrefHeight(300);
        textArea.getStyleClass().remove("text-area");
        textArea.getStyleClass().remove("text-input");
        textArea.getStyleClass().add("text-box-area");
        textArea.setBorder(Border.EMPTY);
        textArea.setPrefWidth(width);
        textArea.setWrapText(true);
        textArea.setEditable(false);

        getChildren().addAll(label, textArea);
    }
}
