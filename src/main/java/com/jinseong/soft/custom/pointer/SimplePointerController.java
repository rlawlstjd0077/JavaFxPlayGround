package com.jinseong.soft.custom.pointer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import main.phone.FxUiUtil;

public class SimplePointerController extends BorderPane {

  @FXML
  private Label pointLabel;

  public SimplePointerController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    initUI();
  }

  private void initUI() {
    this.setOnMouseMoved(this::processMousePoint);
  }

  private void processMousePoint(MouseEvent event) {
    pointLabel.setText(String.format("Current Point: %f, %f", event.getX(), event.getY()));
  }
}
