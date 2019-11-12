package test;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;


public class TrayMenu extends Frame {
    private final transient Stage primaryStage;
    private final transient TrayIcon trayIcon;

    public TrayMenu(Stage stage,
                    TrayIcon trayIcon) {
        primaryStage = stage;
        this.trayIcon = trayIcon;

        primaryStage.setAlwaysOnTop(true);
    }

    public void addAppToTray() {
        try {
            if (!SystemTray.isSupported()) {
                System.out.println("Failed to display tray icon - no system tray support");
                return;
            }

            Toolkit.getDefaultToolkit();
            final SystemTray systemTray = SystemTray.getSystemTray();

            // Tray icon popup의 "About"의 이벤트 설정
            final MenuItem aboutItem = new MenuItem("About");
            aboutItem.addActionListener(e -> System.out.println("Clicked about menu."));

            // Tray icon popup의 "Exit"의 이벤트 설정
            final MenuItem exitItem = new MenuItem("Exit");
            exitItem.addActionListener(e -> {
                System.out.println("Clicked exit menu");
                handleTerminate();
            });

            final String systemName = "T";
            final PopupMenu popup = new PopupMenu(systemName);
            popup.add(aboutItem);
            popup.addSeparator();
            popup.add(exitItem);

            trayIcon.setPopupMenu(popup);
            trayIcon.setToolTip(systemName);

            systemTray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("Failed to display tray icon");
        }
    }

    private void handleTerminate() {
        Platform.runLater(() -> {
            primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
            SystemTray.getSystemTray().remove(trayIcon);
            System.exit(0);
        });
    }

}
