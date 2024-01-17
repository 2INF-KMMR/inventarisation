package com.app.gui.utils;

import com.app.Main;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Map;

public class Fonts {
    public static Map<FontWeight, String> fredoka = Map.of(
        FontWeight.BOLD, "/fonts/Fredoka/Fredoka-Bold.ttf",
        FontWeight.NORMAL, "/fonts/Fredoka/Fredoka-Regular.ttf",
        FontWeight.LIGHT, "/fonts/Fredoka/Fredoka-Light.ttf",
        FontWeight.MEDIUM, "/fonts/Fredoka/Fredoka-Medium.ttf"
    );

    public static Map<FontWeight, String> inter = Map.of(
        FontWeight.THIN, "/fonts/Inter/Inter-Thin.ttf",
        FontWeight.EXTRA_LIGHT, "/fonts/Inter/Inter-ExtraLight.ttf",
        FontWeight.LIGHT, "/fonts/Inter/Inter-Light.ttf",
        FontWeight.NORMAL, "/fonts/Inter/Inter-Regular.ttf",
        FontWeight.MEDIUM, "/fonts/Inter/Inter-Medium.ttf",
        FontWeight.SEMI_BOLD, "/fonts/Inter/Inter-SemiBold.ttf",
        FontWeight.BOLD, "/fonts/Inter/Inter-Bold.ttf",
        FontWeight.EXTRA_BOLD, "/fonts/Inter/Inter-ExtraBold.ttf",
        FontWeight.BLACK, "/fonts/Inter/Inter-Black.ttf"
    );

    public static Font select(Map<FontWeight, String> fontMap, FontWeight weight, int size) {
        return Font.font(
            loadFont(fontMap.get(weight)).getFamily(),
            size
        );
    }

    static Font loadFont(String path) {
        var stream = Main.class.getResourceAsStream(path);
        return Font.loadFont(stream, 14);
    }
}
