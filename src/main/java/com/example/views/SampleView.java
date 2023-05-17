package com.example.views;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SampleView extends Pane {
    private VBox[] topLabels;
    private HBox[] leftLabels;
    private Pane board;
    // private int[][] values;
    private Pane[][] tiles;

    private final int N = 10;
    private final double OFFSET = 100;
    private final double WIDTH = 40;

    public SampleView() {

        initBoard();
        initLabels();

        getChildren().add(board);

    }

    private void initBoard() {
        board = new Pane();
        board.setLayoutX(OFFSET);
        board.setLayoutY(OFFSET);

        tiles = new Pane[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = new Pane();
                Rectangle r = new Rectangle(WIDTH, WIDTH);
                r.setStroke(Color.LIGHTGRAY);
                r.setStrokeWidth(1);
                r.setFill(Color.WHITE);
                tiles[i][j].getChildren().add(r);
                tiles[i][j].setLayoutX(j * WIDTH);
                tiles[i][j].setLayoutY(i * WIDTH);
                board.getChildren().add(tiles[i][j]);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Rectangle r = new Rectangle();
                r.setWidth(WIDTH * 5);
                r.setHeight(WIDTH * 5);
                r.setLayoutX(i * (5 * WIDTH));
                r.setLayoutY(j * (5 * WIDTH));
                r.setStroke(Color.DARKBLUE);
                r.setStrokeWidth(3);
                r.setFill(Color.TRANSPARENT);
                board.getChildren().add(r);
            }
        }
    }

    private void initLabels() {
        topLabels = new VBox[N];
        leftLabels = new HBox[N];
        for (int i = 0; i < N; i++) {
            topLabels[i] = new VBox();
            topLabels[i].setLayoutX(OFFSET + i * WIDTH);
            topLabels[i].getChildren().add(new Label("1"));
            topLabels[i].getChildren().add(new Label("1"));
            getChildren().add(topLabels[i]);

            leftLabels[i] = new HBox();
            leftLabels[i].setLayoutY(OFFSET + i * WIDTH);
            leftLabels[i].getChildren().add(new Label("1"));
            leftLabels[i].getChildren().add(new Label("1"));
            getChildren().add(leftLabels[i]);
        }

        for (int i = 0; i < N; i++) {
            leftLabels[i] = new HBox();
        }
    }
}