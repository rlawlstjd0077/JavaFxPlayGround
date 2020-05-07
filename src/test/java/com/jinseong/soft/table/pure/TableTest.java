package com.jinseong.soft.table.pure;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import com.jinseong.soft.table.pure.domain.TableData;
import com.jinseong.soft.table.pure.ui.TableController;

public class TableTest extends Application {

  @Test
  public void test() {
    launch();
  }

  private List<TableData> generateTableData() {
    List<TableData> tableDataList = new ArrayList<>();
    tableDataList.add(new TableData("1",  ZonedDateTime.now().minusSeconds(1), "I'm 1", true));
    tableDataList.add(new TableData("2",  ZonedDateTime.now().minusSeconds(2), "I'm 2", false));
    tableDataList.add(new TableData("3",  ZonedDateTime.now().minusSeconds(3), "I'm 3", true));
    tableDataList.add(new TableData("4",  ZonedDateTime.now().minusSeconds(4), "I'm 4", false));
    tableDataList.add(new TableData("5",  ZonedDateTime.now().minusSeconds(5), "I'm 5", true));
    tableDataList.add(new TableData("6",  ZonedDateTime.now().minusSeconds(6), "I'm 6", true));
    tableDataList.add(new TableData("7",  ZonedDateTime.now().minusSeconds(7), "I'm 7", false));
    tableDataList.add(new TableData("8",  ZonedDateTime.now().minusSeconds(8), "I'm 8", false));
    tableDataList.add(new TableData("9",  ZonedDateTime.now().minusSeconds(9), "I'm 9", true));
    return tableDataList;
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    TableController controller = new TableController(generateTableData());
    primaryStage.setScene(new Scene(controller));
    primaryStage.setTitle("Table Test");
    primaryStage.show();
  }
}
