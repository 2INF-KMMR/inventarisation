package com.app.gui.pages;

import com.app.gui.components.Center;
import com.app.gui.components.LabeledBox;
import com.app.logic.ProductManagementSystem;

public class CustomersPage extends Center {
    public CustomersPage() {
        String text = "";
        for (var x : ProductManagementSystem.customers) {
            text += x.toString();
        }

        getChildren().add(
            new LabeledBox(400, "Customers", text)
        );
    }
}
