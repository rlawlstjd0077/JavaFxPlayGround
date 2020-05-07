package com.jinseong.soft.timer;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import com.jinseong.soft.util.FxUtil;

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
        time.textProperty().bind(viewModel.timeProperty());
    }
}
