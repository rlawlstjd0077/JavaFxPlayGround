package com.jinseong.soft.button;

import javafx.scene.layout.BorderPane;
import main.phone.FxUiUtil;

public class ImageButtonController extends BorderPane {

  public ImageButtonController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
  }
}
