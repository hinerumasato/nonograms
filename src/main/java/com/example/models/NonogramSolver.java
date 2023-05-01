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

    public boolean solve() {
        return solve(0, 0);
    }

    private boolean solve(int row, int col) {
        if (row == board.length && col == 0) {
            return true; // đã giải quyết toàn bộ bảng
        }

        if (board[row][col] == 1) {
            // ô vuông này đã được đánh dấu là đen
            return solve(col == board.length - 1 ? row + 1 : row, (col + 1) % board.length);
        }

        for (int i = 1; i >= 0; i--) {
            board[row][col] = i;
            if (isValid(row, col) && solve(col == board.length - 1 ? row + 1 : row, (col + 1) % board.length)) {
                return true;
            }
        }

        board[row][col] = 0; // quay lui nếu không tìm thấy giải pháp hợp lệ
        return false;
    }

    private boolean isValid(int row, int col) {
        return isValidRow(row) && isValidColumn(col);
    }

    private boolean isValidRow(int row) {
        int[] hints = rowHints[row];
        int index = 0;
        int count = 0;

        for (int col = 0; col < board.length; col++) {
            if (board[row][col] == 1) {
                count++;
            } else if (count > 0) {
                if (hints.length <= index || hints[index] != count) {
                    return false;
                }
                index++;
                count = 0;
            }
        }

        if (count > 0 && (hints.length <= index || hints[index] != count)) {
            return false;
        }

        return true;
    }

    private boolean isValidColumn(int col) {
        int[] hints = colHints[col];
        int index = 0;
        int count = 0;

        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == 1) {
                count++;
            } else if (count > 0) {
                if (hints.length <= index || hints[index] != count) {
                    return false;
                }
                index++;
                count = 0;
            }
        }

        if (count > 0 && (hints.length <= index || hints[index] != count)) {
            return false;
        }

        return true;
    }

    public void printSolution() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "#" : ".");
            }
            System.out.println();
        }
    }

    public void printBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] rowHints = {
            {3, 1},
            {2, 2},
            {1, 2, 2},
            {3, 2},
            {1, 2},
            {2, 1},
            {2, 1},
            {1, 1},
            {1, 1},
            {2, 2}
        };
        
        int[][] colHints = {
            {2, 1},
            {1, 1},
            {1, 3},
            {1, 3},
            {3, 1},
            {2, 2},
            {2, 2},
            {2, 2},
            {1, 1},
            {2, 1}
        };
        
        NonogramSolver solver = new NonogramSolver(rowHints, colHints);
        if (solver.solve()) {
            solver.printSolution();
        } else {
            System.out.println("Không tìm thấy giải pháp");
        }
        
    }
}
