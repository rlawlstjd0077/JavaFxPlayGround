package com.jinseong.soft.spinner;

import com.jinseong.soft.image.pure.ImageController;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class SpinnerControllerTest extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    SpinnerController controller = new SpinnerController();
    primaryStage.setScene(new Scene(controller));
    primaryStage.setTitle("Spinner Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}
