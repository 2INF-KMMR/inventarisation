package com.app.controllers.button_controller.receipts;

import com.app.logic.Receipts;
import com.app.logic.models.Receipt;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReceiptsController {
    static public final ReceiptsController instance = new ReceiptsController();

    private ReceiptsController() {
    }

    TextField textField;
    TextArea textArea;
    Button button;

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public void setButton(Button button) {
        button.setOnAction(this::onClick);
        this.button = button;

    }

    private void onClick(ActionEvent actionEvent) {
        var text = textField.getText();
        int idx;
        try {
            idx = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.err.println("Error: The string is not a valid integer");
            return;
        }

        Receipt receipt = Receipts.instance.getReceiptById(idx);
        if (receipt == null) {
            textArea.setText("No receipt with such id was found");
            return;
        }
        textArea.setText(receipt.toString());
    }

}
