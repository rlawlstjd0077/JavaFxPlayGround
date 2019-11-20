package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class FxUtil {


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
}
