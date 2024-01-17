package com.app.gui.pages;

import com.app.controllers.button_controller.receipts.ReceiptsController;
import com.app.gui.components.Center;
import com.app.gui.components.LabeledBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ReceiptsPage extends Center {

    public ReceiptsPage() {

        var vbox = new VBox();
        vbox.setSpacing(10.0);

        Button button = new Button("enter");
        button.getStyleClass().add("my-button");
        button.setMnemonicParsing(false);
        ReceiptsController.instance.setButton(button);

        TextField textField = new TextField();
        textField.setPromptText("id");
        textField.setPrefHeight(button.getPrefHeight() + 28);
        HBox.setHgrow(textField, Priority.ALWAYS);
        ReceiptsController.instance.setTextField(textField);


        HBox row = new HBox();
        row.getChildren().addAll(textField, button);
        var labeledBox = new LabeledBox(400,
            "Receipt",
            ""
        ){{
            ReceiptsController.instance.setTextArea(this.getTextArea());
        }};
        vbox.getChildren().addAll(row, labeledBox);

        setPadding(new Insets(10.0, 0, 10.0, 0));
        getChildren().addAll(vbox);
    }
}
