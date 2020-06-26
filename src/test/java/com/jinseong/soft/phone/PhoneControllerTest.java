package com.jinseong.soft.phone;

import com.jinseong.soft.scroll.ScrollBarController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

public class PhoneControllerTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        PhoneController controller = new PhoneController();
        primaryStage.setScene(new Scene(controller));
        primaryStage.setTitle("21624114 김구광");
        primaryStage.show();
    }

    @Test
    public void test() {
        launch();
    }
}
