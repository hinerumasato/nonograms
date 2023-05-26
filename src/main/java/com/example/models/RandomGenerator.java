package com.example.models;

import java.util.Random;

public class RandomGenerator extends Generator implements GeneratorBehavior {
    private Random rand;

    public RandomGenerator(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = new int[numRows][numCols];
        this.rowConstraints = new int[numRows][];
        this.colConstraints = new int[numCols][];
        this.rand = new Random();
    }

    public RandomGenerator(int numRows, int numCols, int[][] board) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = board;
        this.rowConstraints = new int[numRows][];
        this.colConstraints = new int[numCols][];
        this.rand = new Random();
    }

    @Override
    public NonogramBoard generate() {
        generateBoard();
        generateRowConstraints();
        generateColConstraints();
        return new NonogramBoard(numRows, numCols, rowConstraints, colConstraints, board);
    }

    private void generateBoard() {
        for (int i = 0; i < numRows; i++) {
            int num = rand.nextInt(4);
            if (num == 0)
                generateFull(board[i]);
            else
                for (int j = 0; j < numCols; j++)
                    board[i][j] = rand.nextInt(2);
        }
    }

    private void generateFull(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1;
    }

    public void printResult() {
        System.out.print("   ");
        for (int j = 0; j < numCols; j++) {
            for (int k = 0; k < colConstraints[j].length; k++) {
                System.out.print(colConstraints[j][k] + " ");
            }
            System.out.print("  ");
        }
        System.out.println();
        for (int i = 0; i < numRows; i++) {
            for (int k = 0; k < rowConstraints[i].length; k++) {
                System.out.print(rowConstraints[i][k] + " ");
            }
            System.out.print(" |");
            for (int j = 0; j < numCols; j++) {
                System.out.print(board[i][j] == 1 ? "#" : ".");
            }
            System.out.println();
        }
    }
}
