package com.example.models;

public class Test {
    public static void main(String[] args) {
        NonogramGenerator generator = new NonogramGenerator(new RandomNonogramGenerator(10, 10));
        NonogramBoard nonogramBoard = generator.generate();
        nonogramBoard.printBoard();
    }
}
