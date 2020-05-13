package com.jinseong.soft.pagination;

import com.jinseong.soft.util.FxUiUtil;
import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;

public class PaginationController extends AnchorPane {

  @FXML
  private Label label;
  @FXML
  private Pagination pagination;

  private final ChangeListener<Number> paginationChangeListener = (observable, oldValue, newValue) -> changePage();


  public PaginationController(int pageSize) {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    pagination.setPageCount(pageSize);
    pagination.currentPageIndexProperty().addListener(paginationChangeListener);
  }

  private void changePage() {
    label.setText(String.format("Current Page: %d", pagination.getCurrentPageIndex()));
  }
}
