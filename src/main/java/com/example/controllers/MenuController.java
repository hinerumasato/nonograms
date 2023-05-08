package com.example.controllers;

import java.io.IOException;

import com.example.App;
import com.example.models.CSSFile;
import com.example.models.FXMLFile;
import com.example.models.ImgFile;
import com.example.models.LevelModel;
import com.example.views.GameView;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MenuController {
    private Button easyButton;
    private Button mediumButton;
    private Button hardButton;

    public MenuController(Button easyButton, Button mediumButton, Button hardButton) {
        this.easyButton = easyButton;
        this.mediumButton = mediumButton;
        this.hardButton = hardButton;
    }

    private void loadGame(LevelModel level) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(new FXMLFile("game").URLLoad());

            if(level.equals(LevelModel.HARD))
                App.setGRID_SIZE(420);
            else App.setGRID_SIZE(290);
            
            GameView gameViewController = new GameView();
            gameViewController.setLevelModel(level);
            loader.setController(gameViewController);

            Scene scene = new Scene(loader.load(), App.APP_SIZE, App.APP_SIZE);
            scene.getStylesheets().add(new CSSFile("nonogram").load());


            stage.setScene(scene);
            stage.getIcons().add(new Image(new ImgFile("app-icon").load()));
            stage.setResizable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        easyButton.setOnAction(event -> {
            loadGame(LevelModel.EASY);
        });

        mediumButton.setOnAction(event -> {
            loadGame(LevelModel.MEDIUM);
        });

        hardButton.setOnAction(event -> {
            loadGame(LevelModel.HARD);
        });
    }

}
