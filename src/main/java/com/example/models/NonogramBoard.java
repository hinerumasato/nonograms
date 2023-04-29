package com.example.models;

import java.util.Arrays;

public class NonogramBoard {

    private int numRows;
    private int numCols;
    private int[][] gridState;
    private int[][] rowNumbers;
    private int[][] colNumbers;
    private int[][] board;

    public NonogramBoard(int numRows, int numCols, int[][] rowNumbers, int[][] colNumbers, int[][] board) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.rowNumbers = rowNumbers;
        this.colNumbers = colNumbers;
        this.gridState = new int[numRows][numCols];
        this.board = board;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int[][] getGridState() {
        return gridState;
    }

    public int[][] getRowNumbers() {
        return rowNumbers;
    }

    public int[][] getColNumbers() {
        return colNumbers;
    }

    public void setGridState(int row, int col, int value) {
        gridState[row][col] = value;
    }

    public int getGridState(int row, int col) {
        return gridState[row][col];
    }

    public void printRowNumbers() {
        System.out.println("ROW NUMBERS");
        for(int i = 0; i < rowNumbers.length; i++)
            System.out.println(Arrays.toString(rowNumbers[i]));
    }

    public void printColNumbers() {
        System.out.println("COL NUMBERS");
        for(int i = 0; i < colNumbers.length; i++)
            System.out.println(Arrays.toString(colNumbers[i]));
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}