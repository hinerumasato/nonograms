package com.example.models;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileGenerator extends Generator implements GeneratorBehavior {

    private String mapPath;

    public FileGenerator(String mapPath) {
        this.mapPath = mapPath;
    }

    @Override
    public NonogramBoard generate() {
        try {
            
            URI uri = new URI(mapPath);
            File file = new File(uri.getPath());
            Scanner scanner = new Scanner(file);
            
            
            List<int[]> boardList = new ArrayList<int[]>();
            while(scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] rowStr = data.split(" ");
                int[] row = new int[rowStr.length];
                for(int i = 0; i < rowStr.length; i++)
                    row[i] = Integer.parseInt(rowStr[i]);
                boardList.add(row);
            }

            board = new int[boardList.size()][];

            for(int i = 0; i < board.length; i++)
                board[i] = boardList.get(i);
            
            numRows = board.length;
            numCols = board[0].length;

            this.rowConstraints = new int[numRows][];
            this.colConstraints = new int[numCols][];
            generateRowConstraints();
            generateColConstraints();


            scanner.close();
            return new NonogramBoard(numRows, numCols, rowConstraints, colConstraints, board);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int[][] generateRowRules() {
        return null;
    }

    public int[][] generateColRules() {
        return null;
    }
    
}
