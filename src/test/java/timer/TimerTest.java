package timer;

import java.awt.TrayIcon;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.junit.Ignore;
import org.junit.Test;
import tray.TrayMenu;

public class TimerTest extends Application {

  @Test
  @Ignore
  public void test() {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    TimerController controller = new TimerController();
    primaryStage.setScene(new Scene(controller));
    primaryStage.show();
  }
}
