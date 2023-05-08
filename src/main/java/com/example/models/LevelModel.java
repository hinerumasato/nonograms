package com.example.models;

public enum LevelModel {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard"),
    CUSTOM("custom");

    private final String level;

    LevelModel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return this.level;
    }
}
