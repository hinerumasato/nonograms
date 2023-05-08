package com.example.controllers;

import com.example.App;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class H_VBoxController {
    private HBox hBox;
    private VBox vBox;

    public H_VBoxController(HBox hBox, VBox vBox) {
        this.hBox = hBox;
        this.vBox = vBox;
        hBox.setPrefSize(App.GRID_SIZE, App.GRID_SIZE);
        vBox.setPrefSize(App.GRID_SIZE, App.GRID_SIZE);
    }

    public void addHBoxLabels(Label[] labels) {
        hBox.getChildren().addAll(labels);
    }

    public void addVBoxLabels(Label[] labels) {
        vBox.getChildren().addAll(labels);
    }

}