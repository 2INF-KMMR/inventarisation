package com.app.gui.nav;

import com.app.controllers.button_controller.nav_button_controllers.LoadReceiptsController;
import com.app.controllers.button_controller.nav_button_controllers.LoadReportController;
import com.app.controllers.button_controller.nav_button_controllers.LoadCustomersController;
import com.app.gui.components.NavButton;

public class NavButtons {
    public static final String mainButtons = "main";
    public static final String shopButtons = "shop";
    private static final NavButton[] buttons = new NavButton[]{
        new NavButton("Customers", () -> deactivate_buttons_except(0)) {{
            setController(new LoadCustomersController(this));
        }},
        new NavButton("Receipts", () -> deactivate_buttons_except(1)) {{
            setController(new LoadReceiptsController(this));
        }},
        new NavButton("Report", () -> deactivate_buttons_except(2)){{
            setController(new LoadReportController(this));
        }}
    };

    private static void deactivate_buttons_except(int idx) {
        NavButton[] button_list = buttons;
        for (int i = 0; i < button_list.length; i++)
            if (idx != i) button_list[i].lowlight();
    }

    public static NavButton[] get() {
        return buttons;
    }


}
