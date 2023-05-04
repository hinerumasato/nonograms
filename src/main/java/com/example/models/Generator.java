package com.example.models;

public abstract class Generator {
    protected int[][] board;
    protected int[][] rowConstraints;
    protected int[][] colConstraints;
    protected int numRows;
    protected int numCols;

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
