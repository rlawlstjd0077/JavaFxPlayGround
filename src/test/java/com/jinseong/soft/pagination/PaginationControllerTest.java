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
    PaginationController imageController = new PaginationController();
    primaryStage.setScene(new Scene(imageController));
    primaryStage.setTitle("Pagination Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}
