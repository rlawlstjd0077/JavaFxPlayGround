package com.jinseong.soft.scroll;

import com.jinseong.soft.spinner.SpinnerController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class ScrollBarControllerTest extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    ScrollBarController controller = new ScrollBarController();
    primaryStage.setScene(new Scene(controller));
    primaryStage.setTitle("Scroll Bar Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}
