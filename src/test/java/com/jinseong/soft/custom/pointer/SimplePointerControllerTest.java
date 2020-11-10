package com.jinseong.soft.custom.pointer;

import com.jinseong.soft.animation.SimpleAnimationController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import junit.framework.TestCase;
import org.junit.Test;

public class SimplePointerControllerTest extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    SimplePointerController pointerController = new SimplePointerController();
    primaryStage.setScene(new Scene(pointerController));
    primaryStage.setTitle("Pointer Test");
    primaryStage.show();
  }

  @Test
  public void test() {
    launch();
  }
}