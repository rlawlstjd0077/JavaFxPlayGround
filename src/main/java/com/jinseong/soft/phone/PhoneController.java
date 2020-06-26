package com.jinseong.soft.phone;

import com.jinseong.soft.util.FxUiUtil;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class PhoneController extends BorderPane {

    @FXML
    private Button fileButton;
    @FXML
    private Button brandOkButton;
    @FXML
    private Button brandSelectButton;
    @FXML
    private HBox container;
    @FXML
    private Button tableSaveButton;

    public PhoneController() {
        FxUiUtil.initializeFont();
        FxUiUtil.loadFxml(this);
        initUI();
    }

    private void initUI() {
        brandOkButton.setOnAction(event -> {
            clickDefault();
        });
        brandSelectButton.setOnAction(event -> {
            clickBrand();
        });
    }

    private void clickBrand() {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        final KeyValue kv = new KeyValue(container.layoutXProperty(), -350);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    private void clickDefault() {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        final KeyValue kv = new KeyValue(container.layoutXProperty(), 0);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().setPrefWidth(200);
        alert.setTitle("확인");
        alert.setHeaderText("회원번호를 입력하시오.");
        alert.showAndWait();
    }

    private void saveFile() {

    }

    private void importFile() {

    }

    private void close() {
        System.exit(1);
    }
}
