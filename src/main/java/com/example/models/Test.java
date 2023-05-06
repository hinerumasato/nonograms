package com.example.models;

public class Test {
    public static void main(String[] args) throws Exception {
        FileModel fileModel = new CSSFile("nonogram");
        System.out.println(fileModel.load());
    }
}
