package com.example.models;

public class ImgFile extends FileModel {

    public ImgFile(String fileName) {
        super(fileName);
        this.folderName = "img";
        this.extension = ".png";
    }
    
}
