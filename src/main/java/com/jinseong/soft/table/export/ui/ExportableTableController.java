package com.jinseong.soft.table.export.ui;

import java.io.File;
import java.util.List;

import com.github.opendevl.JFlat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import javafx.stage.FileChooser;
import com.jinseong.soft.table.pure.domain.TableData;
import com.jinseong.soft.table.pure.ui.TableController;
import main.phone.FxUiUtil;
import com.jinseong.soft.util.JsonUtil;

public class ExportableTableController extends AnchorPane {
  TableController tableController;
  @FXML
  private AnchorPane tableViewContainer;
  @FXML
  private Button exportButton;

  public ExportableTableController(List<TableData> tableDataList) {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    init(tableDataList);
  }

  private void init(List<TableData> tableDataList) {
    tableController = new TableController(tableDataList);
    tableViewContainer.getChildren().add(tableController);
    exportButton.setOnAction(event -> {
      handleExportCsv();
    });
  }

  private void handleExportCsv() {
    final FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("CSV Files (*.csv)", "*.csv");
    final FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All Files (*.*)", "*.*");

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save CSV");
    fileChooser.getExtensionFilters().addAll(csvFilter, allFilter);
    //CSV FileChooser 초기 이름 설정
    fileChooser.setInitialFileName("SAMPLE-CSV.csv");

    File file = fileChooser.showSaveDialog(this.getScene().getWindow());
    try {
      if (file != null) {

        String json = JsonUtil.getGsonSingleton().toJson(this.tableController.getTableView().getItems().toArray()).replaceAll("\"id\".*?,", "");
        JFlat flatMe = new JFlat(json);
        flatMe.json2Sheet().headerSeparator().write2csv(file.getPath());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
