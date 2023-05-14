package com.example.models;

public class LevelButton {
    private String mapPath;
    private String title;


    public static final String CSS_STYLE = "-fx-background-color:transparent;" +
                                            "-fx-text-fill: #121111;" +
                                            "-fx-font-weight: bold;" +
                                            "-fx-background-radius: 15;" +
                                            "-fx-background-image : url(" + new ImgFile("background-button-level").load() + ");" +
                                            "-fx-background-position: center;" +
                                            "-fx-background-repeat: no-repeat;" +
                                            "-fx-background-size: contain;" +
                                            "-fx-cursor: hand;";
    public static final String PREFIX = "Màn ";

    public LevelButton(String mapPath, String title) {
        this.mapPath = mapPath;
        this.title = title;
    }

    public String getMapPath() {
        return mapPath;
    }

    public void setMapPath(String mapPath) {
        this.mapPath = mapPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
