package org.nkon.mediaplayer;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

import java.io.File;

public class ButtonController {
    FileChooser fileChooser;

    @FXML
    private MediaView mediaView;

    public ButtonController() {
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.mp4)", "*.mp4");
        fileChooser.getExtensionFilters().add(filter);
    }



    @FXML
    protected void onOpenFileButtonClick() {

        File file = fileChooser.showOpenDialog(null);
        if (file == null) { return; }
        String filePath = file.toURI().toString();

        if (filePath != null) {
            Media media = new Media(filePath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();

            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            mediaPlayer.play();
        }
    }

    @FXML
    protected void onPlayButtonClick() {

    }

    @FXML
    protected void onPauseButtonClick() {

    }

    @FXML
    protected void onStopButtonClick() {

    }

    @FXML
    protected void onFasterBackwardButtonClick() {

    }

    @FXML
    protected void onFastBackwardButtonClick() {

    }

    @FXML
    protected void onFastForwardButtonClick() {

    }

    @FXML
    protected void onFasterForwardButtonClick() {

    }

    @FXML
    protected void onExitButtonClick() {

    }


}