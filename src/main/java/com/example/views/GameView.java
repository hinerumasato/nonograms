package com.example.views;

import com.example.controllers.GridController;
import com.example.controllers.H_VBoxController;
import com.example.controllers.ImageViewController;
import com.example.controllers.LabelController;
import com.example.controllers.ToggleController;
import com.example.models.HeartModel;
import com.example.models.LevelModel;
import com.example.models.NonogramBoard;
import com.example.models.NonogramGenerator;
import com.example.models.RandomGenerator;
import com.example.models.ToggleModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameView {

    @FXML
    private GridPane gridPane;

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

    @FXML
    private HBox hBox;

    @FXML
    private VBox vBox;

    private LabelController labelController;
    private ToggleController toggleController;
    private GridController gridController;
    private ImageViewController imageViewController;
    private H_VBoxController h_VBoxController;
    private NonogramBoard nonogramBoard;

    private HeartModel heartModel;
    private ToggleModel toggleModel;
    private LevelModel level;

    public void initialize() {
        try {
            NonogramGenerator generator = new NonogramGenerator(new RandomGenerator(level.getSize(), level.getSize()));
            nonogramBoard = generator.generate();

            toggleModel = new ToggleModel(true);
            toggleModel.addListener(nonogramBoard);
            heartModel = new HeartModel(HeartModel.DEFAULT_QUANTITY);

            ImageView[] imageViews = new ImageView[] { imageView1, imageView2, imageView3 };
            Label[] v_Labels = new Label[level.getSize()];
            Label[] h_Labels = new Label[level.getSize()];

            this.toggleController = new ToggleController(toggleModel, toggleButton, toggleStateLabel);
            this.gridController = new GridController(gridPane, nonogramBoard, heartModel);
            this.imageViewController = new ImageViewController(heartModel, imageViews);
            this.labelController = new LabelController(nonogramBoard, v_Labels, h_Labels);
            this.h_VBoxController = new H_VBoxController(hBox, vBox);

            toggleController.initialize();
            gridController.initialize();
            imageViewController.initialize();
            labelController.initialize();
            h_VBoxController.addHBoxLabels(h_Labels);
            h_VBoxController.addVBoxLabels(v_Labels);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLevelModel(LevelModel level) {
        this.level = level;
    }
}