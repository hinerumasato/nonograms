package com.example.controllers;

import com.example.models.NonogramBoard;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GridController implements InvalidationListener {
    @FXML
    private GridPane gridPane;

    @FXML
    private Label v_label_1;

    @FXML
    private Label v_label_2;

    @FXML
    private Label v_label_3;

    @FXML
    private Label v_label_4;

    @FXML
    private Label v_label_5;

    @FXML
    private Label v_label_6;

    @FXML
    private Label v_label_7;

    @FXML
    private Label v_label_8;

    @FXML
    private Label v_label_9;

    @FXML
    private Label v_label_10;

    @FXML
    private Label h_label_1;

    @FXML
    private Label h_label_2;

    @FXML
    private Label h_label_3;

    @FXML
    private Label h_label_4;

    @FXML
    private Label h_label_5;

    @FXML
    private Label h_label_6;

    @FXML
    private Label h_label_7;

    @FXML
    private Label h_label_8;

    @FXML
    private Label h_label_9;

    @FXML
    private Label h_label_10;

    private NonogramBoard nonogramBoard;
    private Button currButton;

    private LabelController labelController;

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public NonogramBoard getNonogramBoard() {
        return nonogramBoard;
    }

    public void setNonogramBoard(NonogramBoard nonogramBoard) {
        this.nonogramBoard = nonogramBoard;
    }

    public void initialize(NonogramBoard nonogramBoard) {
        this.nonogramBoard = nonogramBoard;
        this.labelController = new LabelController(
            nonogramBoard, 
            new Label[] { v_label_1, v_label_2, v_label_3, v_label_4, v_label_5, v_label_6, v_label_7, v_label_8, v_label_9, v_label_10 },
            new Label[] { h_label_1, h_label_2, h_label_3, h_label_4, h_label_5, h_label_6, h_label_7, h_label_8, h_label_9, h_label_10 }
        );
        this.labelController.initialize();
        this.nonogramBoard.addListener(this);
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
                    this.currButton = button;
                    nonogramBoard.setGridState(finalI, finalJ, 1);
                });

                GridPane.setHgrow(button, Priority.ALWAYS);
                GridPane.setVgrow(button, Priority.ALWAYS);

                gridPane.add(button, i, j);
            }
        }
    }

    @Override
    public void invalidated(Observable observable) {
        if (observable instanceof NonogramBoard) {
            NonogramBoard board = (NonogramBoard) observable;
            this.currButton.setStyle("-fx-background-color: #000;");
            // this.currButton.setStyle("-fx-box-sizing: border-box");
            // this.currButton.setStyle("-fx-padding: 3px");
            // this.currButton.setStyle("-fx-background-clip: padding-box");

        }
    }
}
