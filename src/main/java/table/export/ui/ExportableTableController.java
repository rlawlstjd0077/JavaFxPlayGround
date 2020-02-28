package table.export.ui;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javax.swing.text.TableView;
import table.pure.domain.TableData;
import table.pure.ui.TableController;
import util.FxUtil;

public class ExportableTableController extends AnchorPane {
  TableController tableController;
  @FXML
  private AnchorPane tableViewContainer;
  @FXML
  private Button exportButton;

  public ExportableTableController(List<TableData> tableDataList) {
    FxUtil.initializeFont();
    FxUtil.loadFxml(this);
    init(tableDataList);
  }

  private void init(List<TableData> tableDataList) {
    tableController = new TableController(tableDataList);
    tableViewContainer.getChildren().add(tableController);
    exportButton.setOnAction(event -> {

    });
  }
}
