package com.jinseong.soft.button;

import com.jinseong.soft.pagination.PaginationController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class ImageButtonControllerTest extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    ImageButtonController imageController = new ImageButtonController();
    primaryStage.setScene(new Scene(imageController));
    primaryStage.setTitle("Image Button Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}
