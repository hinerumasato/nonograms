package com.example.controllers;

import com.example.models.NonogramBoard;

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
        generateLabels(v_labels, rowRules, " ");
        generateLabels(h_labels, colRules, "\n");
    }

    private void generateLabels(Label[] labels, int[][] rules, String seperator) {
        for(int i = 0; i < rules.length; i++) {
            String labelText = "";
            for(int j = 0; j < rules[i].length; j++) {
                labelText += rules[i][j] + seperator;
            }
            labels[i].setText(labelText);
        }
    }
}
