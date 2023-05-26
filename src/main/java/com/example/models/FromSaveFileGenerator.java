package com.example.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FromSaveFileGenerator extends Generator implements GeneratorBehavior {

    private int[][] listToMatrix(List<int[]> list) {
        int[][] matrix = new int[list.size()][];
        for(int i = 0; i < matrix.length; i++)
            matrix[i] = list.get(i);
        return matrix;
    }

    @Override
    public NonogramBoard generate() {
        try {
            File file = new File(new SaveFile("save").URILoad());
            Scanner scanner = new Scanner(file);
            List<int[]> gridStateList = new ArrayList<int[]>();
            List<int[]> boardList = new ArrayList<int[]>();

            scanner.nextLine();
            scanner.nextLine();

            while(scanner.hasNextLine()) {
                String gridStateLine = scanner.nextLine();
                if(gridStateLine.equals(""))
                    break;
                else {
                    String[] gridStateRowStrArray = gridStateLine.split(" ");
                    int[] gridStateRow = new int[gridStateRowStrArray.length];
                    for(int i = 0; i < gridStateRow.length; i++) {
                        gridStateRow[i] = Integer.parseInt(gridStateRowStrArray[i]);
                    }
                    gridStateList.add(gridStateRow);
                }
            }
            int[][] gridState = listToMatrix(gridStateList);

            while(scanner.hasNextLine()) {
                String boardLine = scanner.nextLine();
                if(boardLine.equals(""))
                    break;
                else {
                    String[] boardRowStrArray = boardLine.split(" ");
                    int[] boardRow = new int[boardRowStrArray.length];
                    for(int i = 0; i < boardRow.length; i++) {
                        boardRow[i] = Integer.parseInt(boardRowStrArray[i]);
                    }
                    boardList.add(boardRow);
                }
            }
            this.board = listToMatrix(boardList);

            this.numRows = this.board.length;
            this.numCols = this.board[0].length;


            this.rowConstraints = new int[numRows][];
            this.colConstraints = new int[numCols][];

            generateRowConstraints();
            generateColConstraints();

            NonogramBoard nonogramBoard = new NonogramBoard(numRows, numCols, rowConstraints, colConstraints, gridState, board);
            scanner.close();
            return nonogramBoard;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
}
