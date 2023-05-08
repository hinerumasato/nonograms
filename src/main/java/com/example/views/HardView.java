package com.example.views;

import com.example.controllers.LabelController;
import com.example.models.NonogramGenerator;
import com.example.models.RandomGenerator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HardView extends GameView {

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
    private Label v_label_11;

    @FXML
    private Label v_label_12;

    @FXML
    private Label v_label_13;

    @FXML
    private Label v_label_14;

    @FXML
    private Label v_label_15;

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

    @FXML
    private Label h_label_11;

    @FXML
    private Label h_label_12;

    @FXML
    private Label h_label_13;

    @FXML
    private Label h_label_14;

    @FXML
    private Label h_label_15;

    @Override
    public void initialize() {
        NonogramGenerator generator = new NonogramGenerator(new RandomGenerator(15, 15));
        nonogramBoard = generator.generate();
        super.initialize();
        Label[] v_Labels = new Label[] { v_label_1, v_label_2, v_label_3, v_label_4, v_label_5, v_label_6, v_label_7,
                v_label_8, v_label_9, v_label_10, v_label_11, v_label_12, v_label_13, v_label_14, v_label_15 };
        Label[] h_Labels = new Label[] { h_label_1, h_label_2, h_label_3, h_label_4, h_label_5, h_label_6, h_label_7,
            h_label_8, h_label_9, h_label_10, h_label_11, h_label_12, h_label_13, h_label_14, h_label_15 };
        this.labelController = new LabelController(nonogramBoard, v_Labels, h_Labels);
        this.labelController.initialize();
    }
}
