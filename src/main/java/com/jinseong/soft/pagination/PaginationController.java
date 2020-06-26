package com.jinseong.soft.pagination;

import com.jinseong.soft.util.FxUiUtil;
import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class PaginationController extends AnchorPane {

  @FXML
  private Label label;
  @FXML
  private Pagination pagination;

  private final ChangeListener<Number> paginationChangeListener = (observable, oldValue, newValue) -> changePage();


  public PaginationController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    pagination.setPageCount(100);
    pagination.setMaxPageIndicatorCount(10);
    pagination.currentPageIndexProperty().addListener(paginationChangeListener);
    pagination.setPageFactory(new Callback<Integer, Node>() {
      @Override
      public Node call(Integer param) {
        return new Label(String.format("Current Page: %d", pagination.getCurrentPageIndex()));
      }
    });
  }

  private void changePage() {
    label.setText(String.format("Current Page: %d", pagination.getCurrentPageIndex()));
  }
}
