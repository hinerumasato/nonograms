package com.example;

import java.io.IOException;

import com.example.controllers.GridController;
import com.example.controllers.LabelController;
import com.example.models.NonogramBoard;
import com.example.models.NonogramGenerator;
import com.example.models.RandomNonogramGenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("nonograms.fxml"));
        Scene scene = new Scene(loader.load());
        NonogramGenerator generator = new NonogramGenerator(new RandomNonogramGenerator(10, 10));
        NonogramBoard nonogramBoard = generator.generate();

        GridController gridController = loader.getController();
        gridController.initialize(nonogramBoard);
        

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}