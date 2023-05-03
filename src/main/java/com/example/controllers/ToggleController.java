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

    public ToggleController(ToggleModel toggleModel, ToggleButton toggleButton, Label toggleStateLabel) {
        this.toggleModel = toggleModel;
        this.toggleButton = toggleButton;
        this.toggleButton.setSelected(true);
        this.toggleStateLabel = toggleStateLabel;
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

    @Override
    public void invalidated(Observable arg0) {
        if(arg0 instanceof ToggleModel) {
            ToggleModel model = (ToggleModel) arg0;
            if(model.isOn())
                toggleStateLabel.setText("IS ON");
            else toggleStateLabel.setText("IS OFF");
        }
    }

}
