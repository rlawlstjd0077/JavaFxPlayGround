package com.jinseong.soft.animation;

import com.jinseong.soft.button.ImageButtonController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class SimpleAnimationControllerTest extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    SimpleAnimationController animationController = new SimpleAnimationController();
    primaryStage.setScene(new Scene(animationController));
    primaryStage.setTitle("Animation Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}
