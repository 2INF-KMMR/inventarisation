package com.app.gui.pages;

import com.app.controllers.StageController;
import com.app.gui.components.Center;
import com.app.gui.components.LabeledBox;
import com.app.logic.Report;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

public class ReportPage extends Center {
    public ReportPage() {
        var report = new Report();

        MenuItem[] items = {
            new MenuItem("Products report"),
            new MenuItem("Sold products report"),
            new MenuItem("Product amount report"),
            new MenuItem("Sold product amount report"),
            new MenuItem("Sold product type amount report"),
            new MenuItem("Product type amount report"),
        };

        String[] reports = {
            report.productsReport(),
            report.soldProductsReport(),
            report.productAmountReport(),
            report.soldProductAmountReport(),
            report.soldProductTypeAmountReport(),
            report.productTypeAmountReport(),
        };

        for (int i = 0; i < items.length; i++) {
            String title = items[i].getText();
            String content = reports[i];
            items[i].setOnAction(e -> {
                StageController.loadPage(
                    StageController.currentStage,
                    new Center() {{
                        getChildren().add(
                            new LabeledBox(
                                300,
                                title,
                                content
                            )
                        );
                    }}
                );
            });
        }

        var menuButton = new MenuButton("Select report type");
        menuButton.setTextFill(Color.WHITE);
        menuButton.getItems().addAll(items);

        getChildren().add(menuButton);
    }
}
