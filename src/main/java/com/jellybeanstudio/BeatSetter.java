

package com.jellybeanstudio;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.util.Duration;

import java.io.File;

public class BeatSetter {

    @FXML
    private GridPane drumGrid;
    @FXML
    private Rectangle beatPlayer;

    private Media media;
    private MediaPlayer mediaPlayer;
    private boolean playing = false;
    private long lastUpdate = 0;
    private int bpm = 130;
    private long startNanos;
    private int currentColumn = 0;
    private int currentRow = 0;
    private int lastBeat = -1;
    private boolean isEnabled = false;


    @FXML
    private void initialize() {
        drumGrid.getColumnConstraints().clear();
        for (int i = 0; i < 4; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(25);
            cc.setHgrow(Priority.ALWAYS);
            drumGrid.getColumnConstraints().add(cc);
        }

        addRegion(drumGrid, 0);
        addRegion(drumGrid, 1);
        addRegion(drumGrid, 2);
        addRegion(drumGrid, 3);




    }

    public double getColumnX(int column) {
        double columnX = 0;

        for (Node n : drumGrid.getChildren()) {
            if (n instanceof BeatCell cell && cell.getColumn() == column) {
                columnX = n.getBoundsInParent().getMinX();
                break;
            }
        }
        return columnX;
    }



    public Rectangle getBeatPlayer() {
        return beatPlayer;
    }


    @FXML
    private void addRegion(GridPane drumGrid, int column) {


        for (int i = 0; i < drumGrid.getRowCount(); i++) {
            drumGrid.add(new BeatCell(i, column, this), column, i);
            //System.out.println("Made a beat cell at row: " + i + " and column: " + column);
        }
    }

    public void moveBeatPlayer(Rectangle beatPlayer) {


        beatPlayer.setX(beatPlayer.getX() + 150);
    }

    public void moveBeatPlayer(Rectangle beatPlayer, int column) {
        double columnX = getColumnX(0);
        beatPlayer.setX(columnX);
    }

    public void playCell(int row, int column) {
        System.out.println(row);
        if (row == 0) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/kick drum.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 1) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/snare drum.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 2) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/closed hi hat.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 3) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/open hi hat.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 4) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/high tom.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 5) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/mid tom.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 6) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/low tom.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 7) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/rimshot.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 8) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/shaker.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 9) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/ride.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 10) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/crash.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 11) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/clap.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 12) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/cowbell.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
        else if (row == 13) {
            Media media = new Media(new File("src/main/resources/com/jellybeanstudio/sounds/Drum Set 909/tambourine.mp3").toURI().toString());
            MediaPlayer player = new MediaPlayer(media);
            player.seek(Duration.ZERO);
            player.play();
        }
    }

    public void setPlaying(boolean value) {
        playing = value;
        if (playing) {
            startNanos = System.nanoTime();
            loop.start();
        }

        else {
            loop.stop();
            clearHighlights();
            moveBeatPlayer(beatPlayer, 0);
        }
    }

    public BeatCell getCellFromCoords(int row, int column) {
        for (Node n : drumGrid.getChildren()) {
            if (n instanceof BeatCell cell
                    && cell.getRow() == row
                    && cell.getColumn() == column) {
                return cell;
            }
        }

        return null;
    }


    private boolean isColliding(BeatCell cell) {
        Bounds beatPlayerBounds = beatPlayer.localToScene(beatPlayer.getBoundsInLocal());
        Bounds cellBounds = cell.localToScene(cell.getBoundsInLocal());

        return beatPlayerBounds.intersects(cellBounds);
    }

    private void clearHighlights() {
        for (Node n : drumGrid.getChildren()) {
            if (n instanceof BeatCell cell && cell.getHighlighted() == true) {
                cell.setHighlighted(false);
            }
        }
    }

    public boolean getPlaying() {
        return playing;
    }


    AnimationTimer loop = new AnimationTimer() {
        @Override
        public void handle(long now) {

            double secondsPerBeat = 60.0 / bpm;
            double elapsed = (System.nanoTime() - startNanos) / 1_000_000_000.0;
            int beat = (int) (elapsed / secondsPerBeat);

            if (!playing) {
                System.out.println("not playing gang");


                stop();
                return;
            }

            if (beat != lastBeat) {
                /*
                BeatCell cell = getCellFromCoords(currentRow, currentColumn);
                System.out.println("Last beat: " + lastBeat);
                System.out.println("Current beat: " + beat);
                lastBeat = beat;
                // 450 = end of drum grid
                if (beatPlayer.getX() == 450) {
                    moveBeatPlayer(beatPlayer, 0);
                }
                else {
                    moveBeatPlayer(beatPlayer);
                }


                if (cell != null && cell.getState() == true) {
                    playCell(currentRow, currentColumn);
                }

                 */
                lastBeat = beat;

                currentColumn = beat % 4;
                moveBeatPlayer(beatPlayer, currentColumn);
                clearHighlights();

                for (int row = 0; row < drumGrid.getRowCount(); row++) {
                    BeatCell cell = getCellFromCoords(row, currentColumn);
                    if (cell != null && cell.getState() == true) {
                        playCell(row, currentColumn);
                        cell.setHighlighted(true);
                    }
                }


                BeatCell cell = getCellFromCoords(currentRow, currentColumn);
                BeatCell lastCell = getCellFromCoords(currentRow, currentColumn - 1);
                BeatCell endCell = getCellFromCoords(currentRow, 3);

                clearHighlights();

                if (cell != null && cell.getState()) {
                    playCell(currentRow, currentColumn);
                    cell.setHighlighted(true);


                }


            }

            if (now - lastUpdate >= 100_000_000L) {
                lastUpdate = now;

                double playerX = beatPlayer.getX();
                for (Node n : drumGrid.getChildren()) {
                    if (n instanceof BeatCell cell && cell.getRow() == 0) {
                        Bounds cellB = cell.localToScene(cell.getBoundsInLocal());

                      /*  System.out.println("row 0 col=" + cell.getColumn()
                                + " cellX=" + cellB.getMinX()
                                + " playerX=" + beatPlayer.getX());

                       */


                        // check whether beat player is within 1 pixel of the cell's left edge
                        if (Math.abs(beatPlayer.getX() - cellB.getMinX()) < 1.0) {
                            System.out.println("match col=" + ( cell.getColumn() + 1 ) );

                            currentRow = cell.getRow();
                            currentColumn = cell.getColumn();


                            isEnabled = cell.getState();


                        }
                    }
                }

            }
        }
    };



}


