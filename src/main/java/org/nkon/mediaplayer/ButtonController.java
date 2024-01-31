package org.nkon.mediaplayer;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class ButtonController {

    @FXML
    protected void onOpenFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.mp4)", "*.mp4");
    }
}