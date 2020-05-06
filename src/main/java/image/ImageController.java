package image;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import util.FxUtil;

import java.io.File;


public class ImageController extends AnchorPane {
    @FXML
    private ImageView imageView;


    public ImageController(File imageFile) {
        FxUtil.initializeFont();
        FxUtil.loadFxml(this);
        initImage(imageFile);
    }

    private void initImage(File imageFile) {
        Image image = new Image(imageFile.toURI().toString());
        //resource 폴더에서 불러오는 방법
        //Image image = new Image(getClass().getResource("Test.png").toExternalForm());
        imageView.setImage(image);
    }
}
