package com.jinseong.soft.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

public class FxUiUtil {
  private static GlyphFont fontAwesome;

  public static FXMLLoader getFxmlLoader(Class<?> clazz) {
    FXMLLoader loader = new FXMLLoader();
    final String fxmlName = clazz.getSimpleName().replace("Controller", "") + ".fxml";
    loader.setLocation(clazz.getResource(fxmlName));
    return loader;
  }

  public static void loadFxml(Parent controller) {
    try {
      final FXMLLoader loader = getFxmlLoader(controller.getClass());
      loader.setRoot(controller);
      loader.setController(controller);
      loader.load();
    } catch (Exception e) {
      throw new RuntimeException("Failed to load FXML", e);
    }
  }


  public static synchronized void initializeFont() {
    String[] fonts = new String[]{
        "Roboto-Black.ttf",
        "Roboto-BlackItalic.ttf",
        "Roboto-Bold.ttf",
        "Roboto-BoldItalic.ttf",
//      "Roboto-Italic.ttf",
//      "Roboto-Light.ttf",
//      "Roboto-LightItalic.ttf",
        "Roboto-Medium.ttf",
        "Roboto-MediumItalic.ttf",
        "Roboto-Regular.ttf",
//      "Roboto-Thin.ttf",
//      "Roboto-ThinItalic.ttf",
        "RobotoCondensed-Bold.ttf",
        "RobotoCondensed-BoldItalic.ttf",
        "RobotoCondensed-Italic.ttf",
//      "RobotoCondensed-Light.ttf",
//      "RobotoCondensed-LightItalic.ttf",
        "RobotoCondensed-Regular.ttf",
    };
    for (String font : fonts) {
      Font.loadFont(FxUiUtil.class.getResourceAsStream("util/fonts/" + font), 12);
    }

    fontAwesome = GlyphFontRegistry.font("FontAwesome");
  }
}
