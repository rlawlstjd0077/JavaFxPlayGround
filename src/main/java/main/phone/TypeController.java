package main.phone;

import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class TypeController extends AnchorPane {
  private final Scene scene = new Scene(this);
  @FXML
  private ImageView imageView;
  @FXML
  private ComboBox<String> comboBox;
  @FXML
  private Button button;

  private Map<String, String> imageMap = new HashMap<String, String>() {{
    put("갤럭시S6", "phone01.png");
    put("갤럭시S7", "phone02.png");
    put("갤럭시S8", "phone03.png");
    put("갤럭시S9", "phone04.png");
  }};

  public TypeController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    initUI();
  }

  private void initUI() {
    comboBox.setItems(FXCollections.observableArrayList(imageMap.keySet()));
    comboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
      imageView.setImage(new Image(TypeController.class.getResource(imageMap.get(newValue)).toExternalForm()));
    });
  }

  public Button getButton() {
    return button;
  }

  public String getType() {
    return comboBox.getSelectionModel().getSelectedItem();
  }

  public Scene getRootScene() {
    return scene;
  }
}
