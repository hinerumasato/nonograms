package com.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class NonogramBoard implements Observable, InvalidationListener {

    private int numRows;
    private int numCols;
    private int[][] gridState;
    private int[][] rowNumbers;
    private int[][] colNumbers;
    private int[][] board;
    private int currentRow;
    private int currentCol;
    private boolean isSquare;

    private List<InvalidationListener> listeners = new ArrayList<InvalidationListener>();

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
        currentRow = row;
        currentCol = col;
        notifyListeners();

    }

    public boolean trySetGridState(int row, int col, int value) {
        int[][] tempGridState = gridState.clone();
        tempGridState[row][col] = value;
        return tempGridState[row][col] == board[row][col];
    }

    public int getGridState(int row, int col) {
        return gridState[row][col];
    }

    public void printRowNumbers() {
        System.out.println("ROW NUMBERS");
        for (int i = 0; i < rowNumbers.length; i++)
            System.out.println(Arrays.toString(rowNumbers[i]));
    }

    public void printColNumbers() {
        System.out.println("COL NUMBERS");
        for (int i = 0; i < colNumbers.length; i++)
            System.out.println(Arrays.toString(colNumbers[i]));
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners() {
        for (InvalidationListener listener : listeners) {
            listener.invalidated(this);
        }
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public void setGridState(int[][] gridState) {
        this.gridState = gridState;
    }

    public void setRowNumbers(int[][] rowNumbers) {
        this.rowNumbers = rowNumbers;
    }

    public void setColNumbers(int[][] colNumbers) {
        this.colNumbers = colNumbers;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public boolean isSquare() {
        return isSquare;
    }

    public void setSquare(boolean isSquare) {
        this.isSquare = isSquare;
    }

    public List<InvalidationListener> getListeners() {
        return listeners;
    }

    public void setListeners(List<InvalidationListener> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void invalidated(Observable arg0) {
        if (arg0 instanceof ToggleModel) {
            ToggleModel toggleModel = (ToggleModel) arg0;
            setSquare(toggleModel.isOn());
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }
}