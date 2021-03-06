package com.jinseong.soft.image;

import com.jinseong.soft.image.pure.ImageController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.File;

public class ImageControllerTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        File imageFile = new File("data/Test.png");
        ImageController imageController = new ImageController(imageFile);
        primaryStage.setScene(new Scene(imageController));
        primaryStage.setTitle("Image Test");
        primaryStage.show();
    }

    @Test
    public void test() {
        launch();
    }
}