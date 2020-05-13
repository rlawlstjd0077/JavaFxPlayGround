package com.jinseong.soft.pagination;

import com.jinseong.soft.image.pure.ImageController;
import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class PaginationControllerTest extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    File imageFile = new File("data/Test.png");
    PaginationController imageController = new PaginationController(10);
    primaryStage.setScene(new Scene(imageController));
    primaryStage.setTitle("Image Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}
