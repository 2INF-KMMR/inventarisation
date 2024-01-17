module com.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app to javafx.fxml;
    exports com.app;
    exports com.app.gui.components;
    opens com.app.gui.components to javafx.fxml;
    exports com.app.gui.utils;
    opens com.app.gui.utils to javafx.fxml;
    exports com.app.controllers.button_controller;
    opens com.app.controllers.button_controller to javafx.fxml;
    exports com.app.controllers.button_controller.nav_button_controllers;
    opens com.app.controllers.button_controller.nav_button_controllers to javafx.fxml;
    exports com.app.gui.nav;
    opens com.app.gui.nav to javafx.fxml;
}