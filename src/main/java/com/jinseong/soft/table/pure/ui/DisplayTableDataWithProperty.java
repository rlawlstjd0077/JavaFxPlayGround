package com.jinseong.soft.table.pure.ui;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import com.jinseong.soft.table.pure.domain.TableDataWithProperty;

public class DisplayTableDataWithProperty {
  public TableColumn[] getColumns() {
    // ID 칼럼
    final TableColumn<TableDataWithProperty, String> idColumn = new TableColumn<>("ID");
    idColumn.setCellValueFactory(item -> item.getValue().idProperty());
    idColumn.setPrefWidth(40);

    //Content 칼럼
    final TableColumn<TableDataWithProperty, String> contentColumn = new TableColumn<>("Content");
    idColumn.setCellValueFactory(item -> item.getValue().contentProperty());
    contentColumn.setPrefWidth(10);

    //DateTime 칼럼
    final TableColumn<TableDataWithProperty, ZonedDateTime> dateTimeColumn = new TableColumn<>("DateTime");
    dateTimeColumn.setCellValueFactory(item -> item.getValue().dateTimeProperty());
    dateTimeColumn.setCellFactory(col -> new TableCell<TableDataWithProperty, ZonedDateTime>() {
      @Override
      protected void updateItem(ZonedDateTime item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
          setText(null);
        } else {
          setText(item.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        }
      }
    });
    dateTimeColumn.setPrefWidth(220);

    //Action 칼럼`
    final TableColumn<TableDataWithProperty, Boolean> actionColumn = new TableColumn<>("Action");
    actionColumn.setCellValueFactory(item -> item.getValue().isButtonVisibleProperty());
    actionColumn.setCellFactory(item -> new TableCell<TableDataWithProperty, Boolean>() {
      @Override
      protected void updateItem(Boolean isButtonVisible, boolean empty) {
        super.updateItem(isButtonVisible, empty);
        if (!empty && isButtonVisible) {
          Button actionButton = new Button("Action");
          actionButton.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().setPrefWidth(200);
            alert.setTitle("Test");
            alert.setHeaderText("Action button clicked!");
            alert.showAndWait();
          });
          setGraphic(actionButton);
        }
      }
    });
    contentColumn.setPrefWidth(200);

    return new TableColumn[]{idColumn, contentColumn, dateTimeColumn, actionColumn};
  }
}
