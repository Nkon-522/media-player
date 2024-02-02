package org.nkon.mediaplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaPlayerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MediaPlayerApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setOnMouseClicked(doubleClicked -> {
            if (doubleClicked.getClickCount() == 2) {
                stage.setFullScreen(!stage.isFullScreen());
            }
        });

        stage.setTitle("Media Player");
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}