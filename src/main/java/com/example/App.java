package com.example;

import java.io.File;
import java.io.IOException;

import com.example.views.MainView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String GAME_TITLE = "NONOGRAM";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("nonograms.fxml"));
        Scene scene = new Scene(loader.load());

        MainView mainView = loader.getController();
        mainView.initialize();
        

        stage.setTitle(GAME_TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}