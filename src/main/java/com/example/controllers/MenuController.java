package com.example.controllers;

import java.io.IOException;

import com.example.models.FXMLFile;
import com.example.models.ImgFile;
import com.example.models.LevelModel;

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
            FXMLLoader loader = new FXMLLoader(new FXMLFile(level.getLevel()).URLLoad());
            Scene scene = new Scene(loader.load());

            stage.setScene(scene);
            stage.getIcons().add(new Image(new ImgFile("app-icon").load()));
            stage.setResizable(false);
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
