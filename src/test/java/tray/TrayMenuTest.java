package tray;

import javafx.application.Application;
import javafx.stage.Stage;
import org.junit.Ignore;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class TrayMenuTest extends Application {
    @Test
    @Ignore
    public void test() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        final InputStream resource = this.getClass().getResourceAsStream("/icons/tray_icon.png");
        TrayIcon trayIcon = new TrayIcon(ImageIO.read(resource));

        TrayMenu trayMenu = new TrayMenu(primaryStage, trayIcon);
        trayMenu.addAppToTray();
    }
}

