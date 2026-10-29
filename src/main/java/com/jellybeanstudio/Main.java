package com.jellybeanstudio;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class Main extends Application {

    private Media media;
    private MediaPlayer mediaPlayer;


    public static void main(String[] args) {Application.launch(args);}

    @Override
    public void start(Stage stage) throws Exception {



        // Temporary root when there are no .fxml
        // Group root = new Group();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Piano Roll (Drum).fxml"));
        Parent root = loader.load();
        BeatSetter beatSetter = loader.getController();
        Rectangle beatPlayer = beatSetter.getBeatPlayer();



        // Create scene and initial set up for window
        Scene scene = new Scene(root);
        Image logo = new Image("com/jellybeanstudio/images/logo.png");
        stage.getIcons().add(logo);
        stage.setTitle("Jelly Bean Studio");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();


        scene.setOnKeyPressed(event -> {
            System.out.println(beatSetter.getPlaying());
            if (event.getCode() == KeyCode.SPACE) {
                if (beatSetter.getPlaying() == true) {
                    beatSetter.setPlaying(false);
                    System.out.println("set playing to false");

                }
                else if (beatSetter.getPlaying() == false) {
                    System.out.printf("set playing to true");
                    beatSetter.setPlaying(true);
                }
            }
        });






    }


}
