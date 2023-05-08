package com.example.models;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public abstract class FileModel {
    protected String fileName;
    protected String path;
    protected String folderName;
    protected String extension;

    public FileModel(String fileName) {
        this.fileName = fileName;
        this.path = "src/main/resources/com/example";
    }

    private File findFile() {
        String realPath = path + "/" + folderName + "/" + fileName + extension;
        File file = new File(realPath);
        if (!file.exists())
            try {
                throw new IOException("No found File !!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return file;
    }

    public URI URILoad() {
        return findFile().toURI();
    }

    public String load() {
        return findFile().toURI().toString();
    }

    public URL URLLoad() {
        try {
            return findFile().toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
