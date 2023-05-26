package com.example.models;

public class SaveFile extends FileModel {

    public SaveFile(String fileName) {
        super(fileName);
        this.folderName = "save_game";
        this.extension = ".txt";
    }
    
}
