package com.example.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.example.App;
import com.example.models.HeartModel;
import com.example.models.LevelModel;
import com.example.models.NonogramBoard;
import com.example.models.NonogramGenerator;
import com.example.models.SaveFile;
import com.example.models.ToggleModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameController {

    @FXML
    private GridPane gridPane;

    @FXML
    private ToggleButton toggleButton;

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

    @FXML
    private MenuItem saveMenuItem;

    private LabelController labelController;
    private ToggleController toggleController;
    private GridController gridController;
    private ImageViewController imageViewController;
    private BoxController boxController;
    private MenuController menuController;
    
    private NonogramBoard nonogramBoard;
    private NonogramGenerator generator;
    private HeartModel heartModel;
    private ToggleModel toggleModel;
    private LevelModel level;

    public void initialize() {
        try {
            nonogramBoard = generator.generate();

            if(nonogramBoard.getNumCols() == LevelModel.HARD.getSize())
                App.setGRID_SIZE(420);
            else App.setGRID_SIZE(290);

            toggleModel = new ToggleModel(true);
            toggleModel.addListener(nonogramBoard);

            ImageView[] imageViews = new ImageView[] { imageView1, imageView2, imageView3 };
            Label[] v_Labels = new Label[nonogramBoard.getBoard().length];
            Label[] h_Labels = new Label[nonogramBoard.getBoard()[0].length];

            this.toggleController = new ToggleController(toggleModel, toggleButton);
            this.gridController = new GridController(gridPane, nonogramBoard, heartModel, menuController);
            this.imageViewController = new ImageViewController(heartModel, imageViews);
            this.labelController = new LabelController(nonogramBoard, v_Labels, h_Labels);
            this.boxController = new BoxController(hBox, vBox);

            toggleController.initialize();
            gridController.initialize();
            imageViewController.initialize();
            labelController.initialize();
            boxController.addHBoxLabels(h_Labels);
            boxController.addVBoxLabels(v_Labels);

            saveMenuItem.setOnAction(event -> {
                saveGame();
            });
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveGame() {
        try {
            int heartQuantity = heartModel.getQuantity();
            int[][] gridState = nonogramBoard.getGridState();
            int[][] board = nonogramBoard.getBoard();
    
            File file = new File(new SaveFile("save").URILoad());
            FileWriter fileWriter = new FileWriter(file);

            String content = "";
            content += heartQuantity + "\n";
            content += "\n";
            for(int i = 0; i < gridState.length; i++) {
                String row = "";
                for(int j = 0; j < gridState[i].length; j++)
                    row += gridState[i][j] + " ";
                content += row.trim() + "\n";
            }

            content += "\n";
            for(int i = 0; i < board.length; i++) {
                String row = "";
                for(int j = 0; j < board[i].length; j++)
                    row += board[i][j] + " ";
                content += row.trim() + "\n";
            }
            
            fileWriter.append(content);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }
    
    public void setLevelModel(LevelModel level) {
        this.level = level;
    }

    public void setGenerator(NonogramGenerator generator) {
        this.generator = generator;
    }

    public NonogramBoard getNonogramBoard() {
        return this.nonogramBoard;
    }

    public void setHeartModel(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    
}
