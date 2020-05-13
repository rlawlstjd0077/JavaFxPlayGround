package com.jinseong.soft.image.pure;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.File;
import com.jinseong.soft.util.FxUiUtil;


public class ImageController extends AnchorPane {
    @FXML
    private ImageView imageView;

    public ImageController(File imageFile) {
        FxUiUtil.initializeFont();
        FxUiUtil.loadFxml(this);
        initImage(imageFile);
    }

    private void initImage(File imageFile) {
        Image image = new Image(imageFile.toURI().toString());
        //resource 폴더에서 불러오는 방법
        //Image com.jinseong.soft.image = new Image(getClass().getResource("Test.png").toExternalForm());
        imageView.setImage(image);
    }
}
