package com.example.controllers;

import com.example.models.HeartModel;
import com.example.models.NonogramBoard;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GridController implements InvalidationListener {
    private GridPane gridPane;
    private NonogramBoard nonogramBoard;
    private HeartModel heartModel;
    private Button[][] buttons;

    public GridController(GridPane gridPane, NonogramBoard nonogramBoard, HeartModel heartModel) {
        this.gridPane = gridPane;
        this.nonogramBoard = nonogramBoard;
        this.heartModel = heartModel;
        this.buttons = new Button[nonogramBoard.getNumRows()][nonogramBoard.getNumCols()];
        this.nonogramBoard.addListener(this);
    }

    public NonogramBoard getNonogramBoard() {
        return nonogramBoard;
    }

    public void setNonogramBoard(NonogramBoard nonogramBoard) {
        this.nonogramBoard = nonogramBoard;
    }

    public void initialize() {
        int row = nonogramBoard.getNumRows();
        int col = nonogramBoard.getNumCols();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                final int finalI = i;
                final int finalJ = j;
                Button button = new Button();
                button.setMaxWidth(Double.MAX_VALUE);
                button.setMaxHeight(Double.MAX_VALUE);
                button.setOnAction(event -> {
                    int value = nonogramBoard.isSquare() ? 1 : 0;
                    boolean isCanSetGridState = nonogramBoard.trySetGridState(finalI, finalJ, value);
                    if (isCanSetGridState)
                        nonogramBoard.setGridState(finalI, finalJ, value);
                    else
                        heartModel.minusOne();
                });

                GridPane.setHgrow(button, Priority.ALWAYS);
                GridPane.setVgrow(button, Priority.ALWAYS);

                gridPane.add(button, j, i); // Cột trước hàng sau
                buttons[i][j] = button;
            }
        }
    }

    @Override
    public void invalidated(Observable observable) {
        if (observable instanceof NonogramBoard) {
            NonogramBoard board = (NonogramBoard) observable;
            boolean isSquare = board.isSquare();
            int row = nonogramBoard.getCurrentRow();
            int col = nonogramBoard.getCurrentCol();

            if (isSquare)
                buttons[row][col].setStyle("-fx-background-color: #555; -fx-background-clip: padding-box; -fx-padding: 3px");
            else {
                buttons[row][col].setStyle(
                        "-fx-background-image:  url('file:/D:/Projects/Java/JavaFX/nonograms/target/classes/com/example/img/x_mark.png'); " +
                        "-fx-background-size:  contain; " +
                        "-fx-background-repeat:  no-repeat; " + 
                        "-fx-background-position: center");
            }
        }
    }
}
