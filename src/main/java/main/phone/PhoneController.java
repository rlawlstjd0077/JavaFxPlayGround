package main.phone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PhoneController extends BorderPane {
    private final Stage stage = new Stage();
    @FXML
    private Button fileButton;
    @FXML
    private Button brandOkButton;
    @FXML
    private Button brandSelectButton;
    @FXML
    private HBox container;
    @FXML
    private Button tableSaveButton;
    @FXML
    private Button typeSelectButton;
    @FXML
    private TextField numTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private TextField brandTextField;
    @FXML
    private TextField dateField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ToggleGroup group;
    @FXML
    private TableView tableView;

    private List<TableData> tableDataList = new ArrayList<>();

    public PhoneController() {
        FxUiUtil.initializeFont();
        FxUiUtil.loadFxml(this);
        initUI();
    }

    private void initUI() {
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem open = new MenuItem("열기   Ctrl+O");
        open.setOnAction(action -> importFile());
        MenuItem save = new MenuItem("저장   Ctrl+S");
        save.setOnAction(event -> saveFile());
        MenuItem seperator = new SeparatorMenuItem();
        MenuItem terminate = new MenuItem("끝내기   Ctrl+X");
        terminate.setOnAction(event -> close());
        contextMenu.getItems().addAll(open, save, seperator, terminate);

        fileButton.setOnMouseClicked(event -> contextMenu.show(fileButton, event.getScreenX(), event.getScreenY()));
        brandSelectButton.setOnAction(event -> clickBrand());

        brandOkButton.setOnAction(event -> {
            clickDefault();
            brandTextField.setText(group.getSelectedToggle().getUserData().toString());
            LocalDate localDate = datePicker.getValue();
            dateField.setText(localDate.toString());
        });
        tableSaveButton.setOnAction(event -> {
            if (numTextField.getText().equals("")) {
                showAlert();
                return;
            }
            addTableData();
        });
        tableView.getColumns().setAll(getColumns());
        typeSelectButton.setOnAction(event -> {
            TypeController typeController = new TypeController();
            typeController.getButton().setOnAction(e -> {
                typeTextField.setText(typeController.getType());
                stage.close();
            });
            stage.setTitle("기종 선택");
            stage.setScene(typeController.getRootScene());
            stage.show();
        });
    }

    private void clickBrand() {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        final KeyValue kv = new KeyValue(container.layoutXProperty(), -350);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    private void clickDefault() {
        final Timeline timeline = new Timeline();
        timeline.setCycleCount(1);
        final KeyValue kv = new KeyValue(container.layoutXProperty(), 0);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().setPrefWidth(200);
        alert.setTitle("확인");
        alert.setHeaderText("회원번호를 입력하시오.");
        alert.showAndWait();
    }

    private void addTableData() {

        int num = Integer.parseInt(numTextField.getText());

        TableData tableData;
        Optional<TableData> exsist = tableDataList.stream().filter(e -> e.getNum() == num).findFirst();
        tableData = exsist.orElseGet(() -> new TableData(
            num,
            typeTextField.getText(),
            brandTextField.getText(),
            dateField.getText()
        ));

        tableDataList.add(tableData);
        tableView.setItems(FXCollections.observableArrayList(tableDataList));
    }

    private void saveFile() {
        try {
            FileChooser fileChooser = new FileChooser();
            File toSave = fileChooser.showSaveDialog(null);
            if (toSave != null) {
                FileOutputStream fos = new FileOutputStream(toSave);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(tableDataList);
                oos.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importFile()  {
        try {
            FileChooser fileChooser = new FileChooser();
            File toSave = fileChooser.showOpenDialog(null);
            if (toSave != null) {
                FileInputStream fis = new FileInputStream(toSave);
                ObjectInputStream ois = new ObjectInputStream(fis);
                tableDataList = (ArrayList) ois.readObject();
                ois.close();
                fis.close();
                tableView.setItems(FXCollections.observableArrayList(tableDataList));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private TableColumn[] getColumns() {
        final TableColumn<TableData, String> numCol = new TableColumn<>("회원번호");
        numCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getNum() + ""));
        numCol.setPrefWidth(80);
        final TableColumn<TableData, String> typeCol = new TableColumn<>("기종");
        typeCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getType()));
        typeCol.setPrefWidth(90);
        final TableColumn<TableData, String> brandCol = new TableColumn<>("통신사");
        brandCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getBrand()));
        brandCol.setPrefWidth(70);
        final TableColumn<TableData, String> dateCol = new TableColumn<>("가입날짜");
        dateCol.setCellValueFactory(item -> new ReadOnlyStringWrapper(item.getValue().getDateTime()));
        dateCol.setPrefWidth(110);

        return new TableColumn[] {numCol, typeCol, brandCol, dateCol};
    }

    private void close() {
        System.exit(1);
    }
}
