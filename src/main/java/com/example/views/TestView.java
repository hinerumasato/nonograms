package com.example.views;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class TestView extends Pane {
    public TestView() {
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(300, 300);
        gridPane.setLayoutX((getWidth() - gridPane.getWidth()) / 2);
        gridPane.setLayoutY((getHeight() - gridPane.getHeight()) / 2);
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++) {
                Button button = new Button();
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setVgrow(button, Priority.ALWAYS);
                GridPane.setHgrow(button, Priority.ALWAYS);
                gridPane.add(button, j, i);
            }
        getChildren().add(gridPane);
    }
}
