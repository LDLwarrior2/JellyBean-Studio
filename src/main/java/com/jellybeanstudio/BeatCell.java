package com.jellybeanstudio;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class BeatCell extends Region {

    private final BeatSetter beatSetter;
    private Color colour = Color.GRAY;
    private final PauseTransition singleClickTimer = new PauseTransition(Duration.millis(250));
    private final int row;
    private final int column;
    private boolean enabled = false;
    private boolean highlighted = false;


    public BeatCell(int row, int column, BeatSetter beatSetter) {
        this.row = row;
        this.column = column;
        this.beatSetter = beatSetter;



        singleClickTimer.setOnFinished(event -> enable());



        setMinSize(0, 0);
        setPrefSize(50, 50);
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        applyColour();
        setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                singleClickTimer.playFromStart();
            }
            else if (event.getClickCount() == 2) {
                singleClickTimer.stop();
                disable();
            }
        });
    }

    public Color getColour() {
        return colour;
    }

    private void disable() {
        if (colour.equals(Color.DODGERBLUE) && !beatSetter.getPlaying()) {
            enabled = false;
            colour = Color.GRAY;
            applyColour();
        }
    }

    private void enable() {
        if (colour.equals(Color.GRAY) && !beatSetter.getPlaying()) {
            enabled = true;
            colour = Color.DODGERBLUE;
            applyColour();
        }
    }

    private void applyColour() {
        String baseColour = colour.equals(Color.DODGERBLUE)
                ? "dodgerblue"
                : "gray";

        String overlayColour = highlighted
                ? "rgba(255, 255, 255, 0.4)"
                : "transparent";

        setStyle(
                "-fx-background-color: " + baseColour + ", " + overlayColour + ";" +
                        "-fx-background-insets: 0, 0;" +
                        "-fx-border-color: black;"
        );
    }

    public void setHighlighted(boolean value) {
        highlighted = value;
        applyColour();
    }

    public int getColumn() {
        return column;
    }

    public int getRow() { return row; }

    public boolean getState() { return enabled; }

    public boolean getHighlighted() { return highlighted; }




}
