package com.example.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.App;
import com.example.models.CSSFile;
import com.example.models.FXMLFile;
import com.example.models.ImgFile;
import com.example.models.LevelModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MenuController implements Initializable {

    @FXML
    private Button easyButton;

    @FXML
    private Button mediumButton;

    @FXML
    private Button hardButton;

    private Stage gameStage;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
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

    public void closeGame() {
        gameStage.close();
    }

    private void loadGame(LevelModel level) {
        try {
            gameStage = new Stage();
            FXMLLoader loader = new FXMLLoader(new FXMLFile("game").URLLoad());

            if(level.equals(LevelModel.HARD))
                App.setGRID_SIZE(420);
            else App.setGRID_SIZE(290);
            
            GameController gameController = new GameController();
            gameController.setLevelModel(level);
            gameController.setMenuController(this);
            loader.setController(gameController);

            Scene scene = new Scene(loader.load(), App.APP_SIZE, App.APP_SIZE);
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
