package com.jinseong.soft.timer;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class TimerTest extends Application {

  @Test
  public void test() {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    TimerController controller = new TimerController();
    primaryStage.setScene(new Scene(controller));
    primaryStage.setTitle("Timer Test");
    primaryStage.show();
  }
}
