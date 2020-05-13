package com.jinseong.soft.table.pure.ui;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import com.jinseong.soft.table.pure.domain.TableData;
import com.jinseong.soft.util.FxUiUtil;

public class TableController extends AnchorPane {

  @FXML
  private TableView<TableData> tableView;

  public TableController(List<TableData> tableDataList) {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    tableView.getColumns().setAll(new DisplayTableData().getColumns());
    tableView.getItems().setAll(tableDataList);
  }

  public TableView<TableData> getTableView() {
    return tableView;
  }
}
