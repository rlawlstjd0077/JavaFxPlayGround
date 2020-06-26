package com.jinseong.soft.spinner;

import main.phone.FxUiUtil;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;
import javafx.scene.layout.AnchorPane;

public class SpinnerController extends AnchorPane {
  @FXML
  private Spinner<Integer> spinnerInt;
  @FXML
  private Spinner<Double> spinnerDouble;
  @FXML
  private Spinner<String> spinnerList;

  public SpinnerController() {
    FxUiUtil.initializeFont();
    FxUiUtil.loadFxml(this);
    initSpinnerInt();
    initSpinnerDouble();
    initSpinnerList();
  }

  private void initSpinnerInt() {
    IntegerSpinnerValueFactory valueFactory = new IntegerSpinnerValueFactory(0, 100, 50, 1);
    spinnerInt.setValueFactory(valueFactory);
  }

  private void initSpinnerDouble() {
    DoubleSpinnerValueFactory valueFactory = new DoubleSpinnerValueFactory(0, 100, 50, 0.5);
    spinnerDouble.setValueFactory(valueFactory);
  }

  private void initSpinnerList() {
    List<String> testList = new ArrayList<String>() {{
      add("first"); add("second"); add("third"); add("fourth"); add("fifth");
    }};
    ObservableList<String> list = FXCollections.observableArrayList(testList);
    ListSpinnerValueFactory<String> valueFactory = new ListSpinnerValueFactory<>(list);
    spinnerList.setValueFactory(valueFactory);
    spinnerList.setEditable(true);
  }
}
