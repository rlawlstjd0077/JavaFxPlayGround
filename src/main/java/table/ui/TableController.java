package table.ui;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import sun.plugin.util.UIUtil;
import table.domain.TableData;
import util.FxUtil;

public class TableController extends AnchorPane {

  @FXML
  private TableView<TableData> tableView;

  public TableController(List<TableData> tableDataList) {
    FxUtil.initializeFont();
    FxUtil.loadFxml(this);
    tableView.getColumns().setAll(new DisplayTableData().getColumns());
    tableView.getItems().setAll(tableDataList);
  }
}