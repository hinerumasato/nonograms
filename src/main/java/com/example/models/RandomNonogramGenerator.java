package com.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNonogramGenerator implements NonogramGeneratorBehavior {
    private int[][] board;
    private int[][] rowConstraints;
    private int[][] colConstraints;
    private int numRows;
    private int numCols;
    private Random rand;

    public RandomNonogramGenerator(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = new int[numRows][numCols];
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

    private void generateColConstraints() {
        for(int i = 0; i < numRows; i++) {
            List<Integer> colConstraint = new ArrayList<Integer>();
            int count = 0;
            for(int j = 0; j < numCols; j++)
                if(board[j][i] == 1) {
                    count++;
                    if(j == numCols - 1) {
                        colConstraint.add(count);
                        count = 0;
                    }
                }
            else {
                if(count != 0) {
                    colConstraint.add(count);
                    count = 0;
                }
            }

            if(count == numRows) {
                colConstraint.add(count);
                count = 0;
            }

            int[] result = new int[colConstraint.size()];
            for(int j = 0; j < result.length; j++)
                result[j] = colConstraint.get(j);
            colConstraints[i] = result;
        }
    }

    private void generateRowConstraints() {
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowConstraint = new ArrayList<Integer>();
            int count = 0;
            for (int j = 0; j < numCols; j++)
                if (board[i][j] == 1) {
                    count++;
                    if (j == numCols - 1) {
                        rowConstraint.add(count);
                        count = 0;
                    }
                } else {
                    if (count != 0) {
                        rowConstraint.add(count);
                        count = 0;
                    }
                }

            if (count == numRows) {
                rowConstraint.add(count);
                count = 0;
            }

            int[] result = new int[rowConstraint.size()];
            for (int j = 0; j < result.length; j++)
                result[j] = rowConstraint.get(j);
            rowConstraints[i] = result;
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

    public static void main(String[] args) {
        
    }
}
