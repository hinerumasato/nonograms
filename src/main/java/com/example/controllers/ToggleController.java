package com.example.controllers;

import com.example.models.ToggleModel;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class ToggleController implements InvalidationListener {
    private ToggleModel toggleModel;
    private Label toggleStateLabel;
    private ToggleButton toggleButton;

    public ToggleController(ToggleModel toggleModel, ToggleButton toggleButton) {
        this.toggleModel = toggleModel;
        this.toggleButton = toggleButton;
        this.toggleButton.setSelected(true);
        this.toggleModel.addListener(this);
        this.toggleModel.notifyListeners();
    }

    public ToggleModel getToggleModel() {
        return toggleModel;
    }

    public void setToggleModel(ToggleModel toggleModel) {
        this.toggleModel = toggleModel;
    }

    public Label getToggleStateLabel() {
        return toggleStateLabel;
    }

    public void setToggleStateLabel(Label toggleStateLabel) {
        this.toggleStateLabel = toggleStateLabel;
    }

    public ToggleButton getToggleButton() {
        return toggleButton;
    }

    public void setToggleButton(ToggleButton toggleButton) {
        this.toggleButton = toggleButton;
    }

    public void initialize() {
        toggleButton.setOnAction(event -> {
            if(toggleButton.isSelected())
                toggleModel.setOn(true);
            else toggleModel.setOn(false);
        });
    }

    private void setToggleOn(ToggleButton toggleButton) {
        toggleButton.setText("TÔ MÀU");
        toggleButton.setStyle("-fx-background-color: green; -fx-font-weight:bold; -fx-text-fill: white; -fx-padding: 5 15; -fx-border-color: black; -fx-border-radius: 5;");
    }

    private void setToggleOff(ToggleButton toggleButton) {
        toggleButton.setText("ĐÁNH DẤU");
        toggleButton.setStyle("-fx-background-color: red; -fx-font-weight:bold; -fx-text-fill: white; -fx-padding: 5 15; -fx-border-color: black; -fx-border-radius: 5;");
    }

    @Override
    public void invalidated(Observable observable) {
        if(observable instanceof ToggleModel) {
            ToggleModel model = (ToggleModel) observable;
            if(model.isOn())
                setToggleOn(toggleButton);
            else setToggleOff(toggleButton);
        }
    }

}
