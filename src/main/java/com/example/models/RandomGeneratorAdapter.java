package com.example.models;

public class RandomGeneratorAdapter extends FileGenerator {

    private RandomGenerator randomGenerator;

    public RandomGeneratorAdapter(String mapPath, int numRows, int numCols, int[][] board) {
        super(mapPath);
        this.randomGenerator = new RandomGenerator(numRows, numCols, board);
    }


    @Override
    public int[][] generateRowRules() {
        randomGenerator.generateRowConstraints();
        return randomGenerator.getRowConstraints();
    }

    @Override
    public int[][] generateColRules() {
        randomGenerator.generateColConstraints();
        return randomGenerator.getColConstraints();
    }

}
