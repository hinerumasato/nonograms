package com.example.controllers;

import com.example.models.NonogramBoard;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GridController implements InvalidationListener {
    private GridPane gridPane;
    private NonogramBoard nonogramBoard;
    private Button[][] buttons;

    public GridController(GridPane gridPane, NonogramBoard nonogramBoard) {
        this.gridPane = gridPane;
        this.nonogramBoard = nonogramBoard;
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
                    nonogramBoard.setGridState(finalI, finalJ, 1);
                });


                GridPane.setHgrow(button, Priority.ALWAYS);
                GridPane.setVgrow(button, Priority.ALWAYS);

                gridPane.add(button, i, j);
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

            if(isSquare)
                buttons[row][col].setStyle("-fx-background-color: #000");
            else buttons[row][col].setStyle("-fx-background-color: red");
        }
    }
}
