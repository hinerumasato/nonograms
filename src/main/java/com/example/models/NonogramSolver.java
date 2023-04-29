package com.example.models;

import java.util.Arrays;

public class NonogramSolver {
    private int[][] board;
    private int[][] rowHints;
    private int[][] colHints;

    public NonogramSolver(int[][] rowHints, int[][] colHints) {
        this.board = new int[rowHints.length][colHints.length];
        this.rowHints = rowHints;
        this.colHints = colHints;
    }

    public boolean solve(int row, int col) {
        // Kiểm tra xem đã điền đủ ô trong bảng Nonogram chưa
        printBoard();
        if (row == board.length) {
            return isSolution();
        }

        // Tính toán vị trí hàng và cột tiếp theo
        int nextRow = col == board[0].length - 1 ? row + 1 : row;
        int nextCol = col == board[0].length - 1 ? 0 : col + 1;

        // Thử giá trị trắng và đen cho ô hiện tại
        board[row][col] = 0;
        if (isValid(row, col) && solve(nextRow, nextCol)) {
            return true;
        }
        board[row][col] = 1;
        if (isValid(row, col) && solve(nextRow, nextCol)) {
            return true;
        }

        // Không tìm thấy giải pháp
        board[row][col] = 0;
        return false;
    }

    private boolean isValid(int row, int col) {
        int value = board[row][col];
        int rowCount = board.length;
        int colCount = board[0].length;
        
        // Kiểm tra giá trị của ô vuông tại vị trí (row, col) có phù hợp với các ràng buộc của hàng và cột hay không
        if (!isValidRow(rowHints[row], board[row]) || !isValidCol(colHints[col], getColumn(board, col))) {
            return false;
        }
        
        // Kiểm tra xem ô vuông tại vị trí (row, col) có bị trùng với ô vuông khác trong hàng hoặc cột của nó không
        for (int i = 0; i < rowCount; i++) {
            if (i != row && board[i][col] == value) {
                return false;
            }
        }
        for (int j = 0; j < colCount; j++) {
            if (j != col && board[row][j] == value) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(int[] hints, int[] row) {
        int count = 0;
        int current = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                current++;
            } else {
                if (current > 0) {
                    count++;
                    current = 0;
                }
            }
        }
        if (current > 0) {
            count++;
        }
        return Arrays.equals(hints, new int[]{count});
    }
    
    private boolean isValidCol(int[] hints, int[] col) {
        return isValidRow(hints, col);
    }

    private int[] getColumn(int[][] board, int col) {
        int[] column = new int[board.length];
        for (int i = 0; i < column.length; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    private boolean isSolution() {
        // Kiểm tra xem bảng Nonogram có đúng với mô tả của hàng và cột không
        for (int i = 0; i < board.length; i++) {
            if (!isValidRow(rowHints[i], board[i])) {
                return false;
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (!isValidCol(colHints[j], getColumn(board, j))) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1)
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] rowHints = { { 3 }, { 2, 2 }, { 2, 2 }, { 3 } };
        int[][] colHints = { { 2 }, { 2 }, { 2, 2 }, { 3 } };
        NonogramSolver solver = new NonogramSolver(rowHints, colHints);
        solver.solve(0, 0);
    }
}