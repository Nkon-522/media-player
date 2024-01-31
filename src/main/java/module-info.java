module org.nkon.mediaplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.nkon.mediaplayer to javafx.fxml;
    exports org.nkon.mediaplayer;
}