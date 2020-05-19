package com.jinseong.soft.spinner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class SpinnerInitalizedControllerTest extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    SpinnerInitializedController controller = new SpinnerInitializedController();
    primaryStage.setScene(new Scene(controller));
    primaryStage.setTitle("Spinner Initialized Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}
