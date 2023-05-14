package com.example.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.App;
import com.example.models.CSSFile;
import com.example.models.FXMLFile;
import com.example.models.FileGenerator;
import com.example.models.ImgFile;
import com.example.models.LevelButton;
import com.example.models.LevelButtonManagement;
import com.example.models.NonogramGenerator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class LevelSelectController implements Initializable {
    @FXML
    private GridPane gridPane;
    private final int COL_NUM = 5;
    private Stage gameStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int col = 0;
        int row = 0;

        LevelButtonManagement levelButtonManagement = new LevelButtonManagement();
        for(LevelButton levelButton : levelButtonManagement.getLevelButtons()) {
            Button button = new Button(levelButton.getTitle());
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button.setStyle(LevelButton.CSS_STYLE);
            button.setOnAction(event -> {
                System.out.println(levelButton.getMapPath());
                System.out.println(levelButton.getTitle());
                buttonHandle(levelButton.getMapPath());
            });
            
            GridPane.setVgrow(button, Priority.ALWAYS);
            GridPane.setHgrow(button, Priority.ALWAYS);
            gridPane.setVgap(10);
            gridPane.add(button, col, row);
            if(col + 1 == COL_NUM) {
                col = 0;
                row++;
            }
            else col++;
        }
    }

    public void buttonHandle(String mapPath) {
        try {
            gameStage = new Stage();
            FXMLLoader loader = new FXMLLoader(new FXMLFile("game").URLLoad());
            
            GameController gameController = new GameController();
            gameController.setGenerator(new NonogramGenerator(new FileGenerator(mapPath)));
            loader.setController(gameController);
            
            Scene scene = new Scene(loader.load(), App.APP_WIDTH, App.APP_HEIGHT);
            scene.getStylesheets().add(new CSSFile("nonogram").load());


            gameStage.setScene(scene);
            gameStage.getIcons().add(new Image(new ImgFile("app-icon").load()));
            gameStage.setResizable(true);
            gameStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
