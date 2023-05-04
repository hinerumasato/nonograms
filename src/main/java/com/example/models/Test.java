package com.example.models;

public class Test {
    public static void main(String[] args) {
        NonogramGenerator generator = new NonogramGenerator(new FileGenerator("target/classes/com/example/maps/map1.txt"));
        NonogramBoard nonogramBoard = generator.generate();
        nonogramBoard.printBoard();
        // nonogramBoard.printRowNumbers();
        nonogramBoard.printColNumbers();
    }
}
