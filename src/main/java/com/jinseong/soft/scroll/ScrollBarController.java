package com.jinseong.soft.scroll;

import com.jinseong.soft.util.FxUiUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;

public class ScrollBarController extends AnchorPane {

  @FXML
  private Label verticalLabel;
  @FXML
  private Label horizontalLabel;
  @FXML
  private ScrollBar horizontalScrollBar;
  @FXML
  private ScrollBar verticalScrollBar;
  @FXML
  private Button testButton;

  public ScrollBarController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    initUI();
  }

  private void initUI() {
    horizontalScrollBar.setMin(0);
    horizontalScrollBar.setMax(100);
    horizontalScrollBar.setBlockIncrement(1);
    horizontalScrollBar.setUnitIncrement(1);
    horizontalScrollBar.setVisibleAmount(10);
    horizontalScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
      horizontalLabel.setText(String.format("Horizontal Value: %f", newValue));
    });

    verticalScrollBar.setMin(0);
    verticalScrollBar.setMax(100);
    verticalScrollBar.setBlockIncrement(1);
    verticalScrollBar.setUnitIncrement(1);
    verticalScrollBar.setVisibleAmount(10);
    verticalScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
      verticalLabel.setText(String.format("Vertical Value: %f", newValue));
    });
  }
}
