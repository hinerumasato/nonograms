package com.example.models;

import java.io.File;

public abstract class FileModel {
    protected String fileName;
    protected String path;
    protected String folderName;
    protected String extension;

    public FileModel(String fileName) {
        this.fileName = fileName;
        this.path = "src/main/resources/com/example";
    }

    public String load() {
        String realPath = path + "/" + folderName + "/"  + fileName + extension;
        File file = new File(realPath);
        if(!file.exists())
            try {
                throw new Exception("No found File !!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return file.toURI().toString();
    }
    
}
