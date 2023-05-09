package com.example.views;

import com.example.models.CSSFile;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public class TestView extends Pane {
    public TestView() {
        ToggleButton toggleButton = new ToggleButton();
        toggleButton.getStyleClass().add("modern-toggle-button");
        toggleButton.setText("OFF");
        toggleButton.setSelected(false);
        getStylesheets().add(new CSSFile("nonogram").load());
        getChildren().add(toggleButton);
    }
}
