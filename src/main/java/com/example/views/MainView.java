package com.example.views;

import com.example.controllers.GridController;
import com.example.controllers.ImageViewController;
import com.example.controllers.LabelController;
import com.example.controllers.ToggleController;
import com.example.models.FileGenerator;
import com.example.models.HeartModel;
import com.example.models.NonogramBoard;
import com.example.models.NonogramGenerator;
import com.example.models.ToggleModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class MainView {
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

    @FXML
    private ToggleButton toggleButton;

    @FXML
    private Label toggleStateLabel;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    private LabelController labelController;
    private ToggleController toggleController;
    private GridController gridController;
    private ImageViewController imageViewController;

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void initialize() {
        NonogramGenerator generator = new NonogramGenerator(new FileGenerator("target/classes/com/example/maps/map1.txt"));
        NonogramBoard nonogramBoard = generator.generate();
        ToggleModel toggleModel = new ToggleModel(true);
        toggleModel.addListener(nonogramBoard);
        HeartModel heartModel = new HeartModel(HeartModel.DEFAULT_QUANTITY);
        Label[] v_Labels = new Label[] { v_label_1, v_label_2, v_label_3, v_label_4, v_label_5, v_label_6, v_label_7, v_label_8, v_label_9, v_label_10 };
        Label[] h_Labels = new Label[] { h_label_1, h_label_2, h_label_3, h_label_4, h_label_5, h_label_6, h_label_7, h_label_8, h_label_9, h_label_10 };

        ImageView[] imageViews = new ImageView[] { imageView1, imageView2, imageView3 };

        this.labelController = new LabelController(nonogramBoard, v_Labels, h_Labels);   
        this.toggleController = new ToggleController(toggleModel, toggleButton ,toggleStateLabel);
        this.gridController = new GridController(gridPane, nonogramBoard, heartModel);
        this.imageViewController = new ImageViewController(heartModel, imageViews);

        labelController.initialize();
        toggleController.initialize();
        gridController.initialize();
        imageViewController.initialize();
    }

}
