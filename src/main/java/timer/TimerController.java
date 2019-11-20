package timer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import util.FxUtil;

public class TimerController extends StackPane {

  @FXML
  private Text time;
  TimerViewModel viewModel;

  public TimerController() {
    viewModel = new TimerViewModel();
    FxUtil.loadFxml(this);
    init();
  }

  private void init() {
    viewModel.timeProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        System.out.println("asfas");
      }
    });
    time.textProperty().bind(viewModel.timeProperty());
  }
}
