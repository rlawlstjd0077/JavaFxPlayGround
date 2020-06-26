package main.phone;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    PhoneController controller = new PhoneController();
    primaryStage.setScene(new Scene(controller));
    primaryStage.setTitle("21624114 김구광");
    primaryStage.show();
  }
}
