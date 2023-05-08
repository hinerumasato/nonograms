package com.example.views;

import com.example.controllers.LabelController;
import com.example.models.NonogramGenerator;
import com.example.models.RandomGenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EasyView extends GameView {
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
    private Label h_label_1;

    @FXML
    private Label h_label_2;

    @FXML
    private Label h_label_3;

    @FXML
    private Label h_label_4;

    @FXML
    private Label h_label_5;

    @Override
    public void initialize() {
        NonogramGenerator generator = new NonogramGenerator(new RandomGenerator(5, 5));
        nonogramBoard = generator.generate();
        super.initialize();
        Label[] v_Labels = new Label[] { v_label_1, v_label_2, v_label_3, v_label_4, v_label_5 };
        Label[] h_Labels = new Label[] { h_label_1, h_label_2, h_label_3, h_label_4, h_label_5 };
        this.labelController = new LabelController(nonogramBoard, v_Labels, h_Labels);
        this.labelController.initialize();
    }
}
