package com.jinseong.soft.spinner;

import com.jinseong.soft.util.FxUiUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;

public class SpinnerInitializedController extends AnchorPane {
  @FXML
  private Spinner<Integer> spinnerWithFactory;
  @FXML
  private Spinner<Double> spinnerWithoutFactory;

  public SpinnerInitializedController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
  }
}
