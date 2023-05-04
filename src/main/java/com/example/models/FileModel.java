package com.example.models;

import java.io.File;

public abstract class FileModel {
    protected String fileName;
    protected String path;
    protected String folderName;
    protected String extension;

    public FileModel(String fileName) {
        this.fileName = fileName;
        this.path = "target/classes/com/example";
    }

    public String load() throws Exception {
        String realPath = path + "/" + folderName + "/"  + fileName + extension;
        File file = new File(realPath);
        if(!file.exists())
            throw new Exception("No found File !!");
        return file.toURI().toString();
    }
    
}
