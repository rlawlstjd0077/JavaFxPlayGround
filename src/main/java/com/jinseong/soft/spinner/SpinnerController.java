package com.jinseong.soft.spinner;

import com.jinseong.soft.util.FxUiUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;

public class SpinnerController extends AnchorPane {
  @FXML
  private Spinner<Integer> spinner;

  public SpinnerController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    initSpinner();
  }

  private void initSpinner() {

  }

  private void initSpinnerToString() {

  }
}
