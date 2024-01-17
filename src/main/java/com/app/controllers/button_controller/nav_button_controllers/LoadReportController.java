package com.app.controllers.button_controller.nav_button_controllers;
import com.app.controllers.StageController;
import com.app.controllers.button_controller.ButtonController;
import com.app.gui.pages.ReportPage;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class LoadReportController extends ButtonController {
    public LoadReportController(Button _button) {
        super(_button);
    }

    @Override
    public void onClick(MouseEvent event) {
        StageController.loadPage(
            StageController.eventToStage(event),
            new ReportPage()
        );
    }
}
