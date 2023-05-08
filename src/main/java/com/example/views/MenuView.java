package com.example.views;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.controllers.MenuController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuView implements Initializable {

    @FXML
    private Button easyButton;

    @FXML
    private Button mediumButton;

    @FXML
    private Button hardButton;

    private MenuController menuController;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.menuController = new MenuController(easyButton, mediumButton, hardButton);
        menuController.initialize();
    }

}
