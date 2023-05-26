package com.example.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Generator {
    protected int[][] board;
    protected int[][] rowConstraints;
    protected int[][] colConstraints;
    protected int numRows;
    protected int numCols;

    public void generateColConstraints() {
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

    public void generateRowConstraints() {
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

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getRowConstraints() {
        return rowConstraints;
    }

    public void setRowConstraints(int[][] rowConstraints) {
        this.rowConstraints = rowConstraints;
    }

    public int[][] getColConstraints() {
        return colConstraints;
    }

    public void setColConstraints(int[][] colConstraints) {
        this.colConstraints = colConstraints;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

}
