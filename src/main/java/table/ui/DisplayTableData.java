package table.ui;

import java.time.format.DateTimeFormatter;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.adapter.ReadOnlyJavaBeanStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import table.domain.TableData;

public class DisplayTableData {

  public TableColumn[] getColumns() {
    // ID 칼럼
    final TableColumn<TableData, String> idColumn = new TableColumn<>("ID");
    idColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getId()));
    idColumn.setPrefWidth(40);

    //Content 칼럼
    final TableColumn<TableData, String> contentColumn = new TableColumn<>("Content");
    contentColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getContent()));
    contentColumn.setPrefWidth(10);

    //DateTime 칼럼
    final TableColumn<TableData, String> dateTimeColumn = new TableColumn<>("DateTime");
    dateTimeColumn.setCellValueFactory(item -> new ReadOnlyStringWrapper(
        //ZonedDateTime Formatting 하여 전시 (예: 2020-02-01 13:00:11.22)
        item.getValue().getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))));
    dateTimeColumn.setPrefWidth(220);

    //Action 칼럼`
    final TableColumn<TableData, Boolean> actionColumn = new TableColumn<>("Action");
    actionColumn.setCellValueFactory(item -> new ReadOnlyBooleanWrapper(item.getValue().isButtonVisible()));
    actionColumn.setCellFactory(item -> new TableCell<TableData, Boolean>() {
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
