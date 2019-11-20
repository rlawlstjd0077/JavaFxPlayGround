package tray;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;

public class TrayMenuLauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        final InputStream resource = this.getClass().getResourceAsStream("/icons/tray_icon.png");
        TrayIcon trayIcon = new TrayIcon(ImageIO.read(resource));

        TrayMenu trayMenu = new TrayMenu(primaryStage, trayIcon);
        trayMenu.addAppToTray();
        while(true) {

        }
    }
}
