package org.nkon.mediaplayer;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

public class ButtonController {
    Duration skip = new Duration(5000.0);
    Duration largerSkip = new Duration(10000.0);
    FileChooser fileChooser;

    @FXML
    private MediaView mediaView;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider playbackSlider;

    MediaPlayer mediaPlayer;

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
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

            DoubleProperty width = mediaView.fitWidthProperty();
            DoubleProperty height = mediaView.fitHeightProperty();

            width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            volumeSlider.setValue(mediaPlayer.getVolume() * 100);
            volumeSlider.valueProperty().addListener(observable -> mediaPlayer.setVolume(volumeSlider.getValue() / 100));

            mediaPlayer.currentTimeProperty().addListener(
                    (observableValue, duration, t1) -> {
                        if ( !playbackSlider.isPressed() ) {
                            playbackSlider.setValue(t1.toSeconds());
                        }
                    }
            );
            mediaPlayer.setOnReady(() -> playbackSlider.setMax( (media.getDuration()).toSeconds()));

            playbackSlider.setOnMouseClicked(mouseEvent -> mediaPlayer.seek(Duration.seconds(playbackSlider.getValue())));

            mediaPlayer.play();
        }
    }

    @FXML
    protected void onPlayButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    @FXML
    protected void onPauseButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @FXML
    protected void onStopButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @FXML
    protected void onFasterBackwardButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(largerSkip) );
        }
    }

    @FXML
    protected void onFastBackwardButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().subtract(skip) );
        }
    }

    @FXML
    protected void onFastForwardButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().add(skip) );
        }
    }

    @FXML
    protected void onFasterForwardButtonClick() {
        if (mediaPlayer != null) {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().add(largerSkip) );
        }
    }

    @FXML
    protected void onExitButtonClick() {

    }


}