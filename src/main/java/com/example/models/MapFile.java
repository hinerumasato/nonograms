package com.example.models;

public class MapFile extends FileModel {

    public MapFile(String fileName) {
        super(fileName);
        this.folderName = "maps";
        this.extension = ".txt";
    }
    
}
