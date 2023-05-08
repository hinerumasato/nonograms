package com.example;

import java.io.IOException;

import com.example.models.CSSFile;
import com.example.models.FXMLFile;
import com.example.models.ImgFile;
import com.example.views.TestView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String GAME_TITLE = "NONOGRAM";

    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(new FXMLFile("menu").URLLoad());
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(new CSSFile("menu").load());
            stage.getIcons().add(new Image(new ImgFile("app-icon").load()));
            stage.setTitle(GAME_TITLE);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }

}