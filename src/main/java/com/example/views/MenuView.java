package com.example.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.models.FXMLFile;
import com.example.models.LevelModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuView implements Initializable {

    @FXML
    private Button easyButton;

    @FXML
    private Button mediumButton;

    @FXML
    private Button hardButton;

    private void loadGame(LevelModel level) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(new FXMLFile(level.getLevel()).URLLoad());
            Scene scene = new Scene(loader.load());

            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

}
