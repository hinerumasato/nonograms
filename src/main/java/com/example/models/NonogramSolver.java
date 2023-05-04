package com.example.models;

public class NonogramSolver {
    private int[][] board;
    private int[][] rowHints;
    private int[][] colHints;

    public NonogramSolver(int[][] rowHints, int[][] colHints) {
        this.rowHints = rowHints;
        this.colHints = colHints;
        this.board = new int[rowHints.length][colHints.length];
    }

    public boolean solveNonogram() {
        return solveNonogram(0, 0);
    }

    private boolean solveNonogram(int row, int col) {
        if (row == rowHints.length) {
            return true;
        }

        if (col == colHints.length) {
            return solveNonogram(row + 1, 0);
        }

        for (int value = 0; value <= 1; value++) {
            board[row][col] = value;

            if (isValidRow(row) && isValidCol(col) && solveNonogram(row, col + 1)) {
                return true;
            }
        }

        board[row][col] = 0;
        return false;
    }

    private boolean isValidRow(int row) {
        int[] hints = rowHints[row];
        int[] values = board[row];

        int hintIndex = 0;
        int valueIndex = 0;

        while (valueIndex < values.length) {
            if (values[valueIndex] == 1) {
                int count = 0;
                while (valueIndex < values.length && values[valueIndex] == 1) {
                    count++;
                    valueIndex++;
                }

                if (hintIndex >= hints.length || count != hints[hintIndex]) {
                    return false;
                }
                hintIndex++;
            } else {
                valueIndex++;
            }
        }

        return hintIndex == hints.length;
    }

    private boolean isValidCol(int col) {
        int[] hints = colHints[col];
        int[] values = new int[rowHints.length];

        for (int row = 0; row < rowHints.length; row++) {
            values[row] = board[row][col];
        }

        int hintIndex = 0;
        int valueIndex = 0;

        while (valueIndex < values.length) {
            if (values[valueIndex] == 1) {
                int count = 0;
                while (valueIndex < values.length && values[valueIndex] == 1) {
                    count++;
                    valueIndex++;
                }

                if (hintIndex >= hints.length || count != hints[hintIndex]) {
                    return false;
                }
                hintIndex++;
            } else {
                valueIndex++;
            }
        }

        return hintIndex == hints.length;
    }

    public void printBoard() {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print(value == 1 ? "#" : ".");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] rowHints = {{1, 1}, {3}, {2}, {1}, {3}};
        int[][] colHints = {{1}, {3}, {2}, {2}, {1}};
        NonogramSolver solver = new NonogramSolver(rowHints, colHints);
        solver.solveNonogram();
        solver.printBoard();
    }
    
}
