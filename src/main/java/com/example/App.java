package com.example;

import java.io.IOException;

import com.example.models.CSSFile;

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medium.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(new CSSFile("nonogram").load());
            stage.setTitle(GAME_TITLE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }

}