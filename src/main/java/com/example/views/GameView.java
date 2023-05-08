package com.example.views;

import com.example.controllers.GridController;
import com.example.controllers.ImageViewController;
import com.example.controllers.LabelController;
import com.example.controllers.ToggleController;
import com.example.models.HeartModel;
import com.example.models.NonogramBoard;
import com.example.models.ToggleModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public abstract class GameView {

    @FXML
    protected GridPane gridPane;

    @FXML
    protected ToggleButton toggleButton;

    @FXML
    protected Label toggleStateLabel;

    @FXML
    protected ImageView imageView1;

    @FXML
    protected ImageView imageView2;

    @FXML
    protected ImageView imageView3;

    protected LabelController labelController;
    protected ToggleController toggleController;
    protected GridController gridController;
    protected ImageViewController imageViewController;
    protected NonogramBoard nonogramBoard;

    public void initialize() {
        try {
            ToggleModel toggleModel = new ToggleModel(true);
            toggleModel.addListener(nonogramBoard);
            HeartModel heartModel = new HeartModel(HeartModel.DEFAULT_QUANTITY);
    
            ImageView[] imageViews = new ImageView[] { imageView1, imageView2, imageView3 };
    
            this.toggleController = new ToggleController(toggleModel, toggleButton ,toggleStateLabel);
            this.gridController = new GridController(gridPane, nonogramBoard, heartModel);
            this.imageViewController = new ImageViewController(heartModel, imageViews);
    
            toggleController.initialize();
            gridController.initialize();
            imageViewController.initialize();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
