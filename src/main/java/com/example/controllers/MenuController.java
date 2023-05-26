package com.example.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.example.App;
import com.example.models.CSSFile;
import com.example.models.FXMLFile;
import com.example.models.FromSaveFileGenerator;
import com.example.models.HeartModel;
import com.example.models.ImgFile;
import com.example.models.LevelModel;
import com.example.models.NonogramGenerator;
import com.example.models.RandomGenerator;
import com.example.models.SaveFile;

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

    @FXML
    private Button newGameButton;

    @FXML
    private Button continueGameButton;

    private Stage loadStage;

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

        newGameButton.setOnAction(event -> {
            loadLevelSelect();
        });

        continueGameButton.setOnAction(event -> {
            loadFromSaveFile();
        });
    }

    public void closeGame() {
        loadStage.close();
    }

    private void loadGame(LevelModel level) {
        try {
            loadStage = new Stage();
            FXMLLoader loader = new FXMLLoader(new FXMLFile("game").URLLoad());
            
            GameController gameController = new GameController();
            gameController.setLevelModel(level);
            gameController.setMenuController(this);
            gameController.setHeartModel(new HeartModel(HeartModel.DEFAULT_QUANTITY));
            gameController.setGenerator(new NonogramGenerator(new RandomGenerator(level.getSize(), level.getSize())));
            loader.setController(gameController);

            Scene scene = new Scene(loader.load(), App.APP_WIDTH, App.APP_HEIGHT);
            scene.getStylesheets().add(new CSSFile("nonogram").load());


            loadStage.setScene(scene);
            loadStage.getIcons().add(new Image(new ImgFile("app-icon").load()));
            loadStage.setResizable(true);
            loadStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLevelSelect() {
        try {
            loadStage = new Stage();
            FXMLLoader loader = new FXMLLoader(new FXMLFile("level").URLLoad());
            Scene scene = new Scene(loader.load());

            scene.getStylesheets().add(new CSSFile("level").load());

            loadStage.setScene(scene);
            loadStage.getIcons().add(new Image(new ImgFile("app-icon").load()));
            loadStage.show();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void loadFromSaveFile() {

        try {
            File file = new File(new SaveFile("save").URILoad());
            Scanner scanner = new Scanner(file);
            int heartQuantity = scanner.nextInt();
            scanner.close();

            loadStage = new Stage();
            FXMLLoader loader = new FXMLLoader(new FXMLFile("game").URLLoad());
            GameController gameController = new GameController();

            gameController.setGenerator(new NonogramGenerator(new FromSaveFileGenerator()));
            gameController.setMenuController(this);
            gameController.setHeartModel(new HeartModel(heartQuantity));

            loader.setController(gameController);

            Scene scene;
            scene = new Scene(loader.load(), App.APP_WIDTH, App.APP_HEIGHT);
            scene.getStylesheets().add(new CSSFile("nonogram").load());

            loadStage.setScene(scene);
            loadStage.getIcons().add(new Image(new ImgFile("app-icon").load()));
            loadStage.setResizable(true);
            loadStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
