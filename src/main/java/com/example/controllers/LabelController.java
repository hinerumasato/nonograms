package com.example.controllers;

import com.example.App;
import com.example.models.NonogramBoard;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class LabelController {
    
    private NonogramBoard nonogramBoard;
    private Label[] v_labels;
    private Label[] h_labels;

    public LabelController(NonogramBoard nonogramBoard, Label[] v_labels, Label[] h_labels) {
        this.nonogramBoard = nonogramBoard;
        this.v_labels = v_labels;
        this.h_labels = h_labels;
    }

    public void initialize() {
        int[][] rowRules = nonogramBoard.getRowNumbers();
        int[][] colRules = nonogramBoard.getColNumbers();
        generateHLabels(h_labels, colRules);
        generateVLabels(v_labels, rowRules);
    }

    private void generateVLabels(Label[] labels, int[][] rules) {
        for(int i = 0; i < rules.length; i++) {
            labels[i] = new Label();
            labels[i].setPrefSize(70, App.GRID_SIZE / labels.length);
            labels[i].setAlignment(Pos.CENTER_RIGHT);
            labels[i].setStyle("-fx-border-color: #000");
            String labelText = "";
            for(int j = 0; j < rules[i].length; j++) {
                labelText += rules[i][j] + " ";
            }
            labels[i].setText(labelText);
        }
    }

    private void generateHLabels(Label[] labels, int[][] rules) {
        for(int i = 0; i < rules.length; i++) {
            labels[i] = new Label();
            labels[i].setPrefSize(App.GRID_SIZE / labels.length, 70);
            labels[i].setAlignment(Pos.BOTTOM_CENTER);
            labels[i].setStyle("-fx-border-color: #000");
            String labelText = "";
            for(int j = 0; j < rules[i].length; j++) {
                labelText += rules[i][j] + "\n";
            }
            labels[i].setText(labelText);
        }
    }
}
