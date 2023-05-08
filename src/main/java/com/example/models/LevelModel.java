package com.example.models;

public enum LevelModel {
    EASY(5),
    MEDIUM(10),
    HARD(15);

    private final int size;

    LevelModel(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
