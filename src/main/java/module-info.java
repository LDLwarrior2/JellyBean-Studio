module com.jellybeanstudio {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.jellybeanstudio to javafx.fxml;
    exports com.jellybeanstudio;
}