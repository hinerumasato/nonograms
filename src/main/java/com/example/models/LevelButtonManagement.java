package com.example.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LevelButtonManagement {
    private List<LevelButton> levelButtons = new ArrayList<LevelButton>();

    private String formatFileName(String fileName) {
        return fileName.substring(0, fileName.indexOf('.'));
    }

    private void sortListFile(String[] listFile) {
        int[] nums = new int[listFile.length];
        for(int i = 0; i < nums.length; i++) {
            String fileName = formatFileName(listFile[i]);
            String numStr = fileName.substring(3, fileName.length());
            nums[i] = Integer.parseInt(numStr);
        }

        for(int i = 0; i < nums.length - 1; i++)
            for(int j = i+1; j < nums.length; j++)
                if(nums[i] > nums[j]) {
                    String tempStr = listFile[i];
                    listFile[i] = listFile[j];
                    listFile[j] = tempStr;

                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
    }

    public LevelButtonManagement() {
        File file = new File(new Folder("maps").URILoad());
        String[] listFile = file.list();

        sortListFile(listFile);
        
        for(int i = 0; i < listFile.length; i++) {
            String fileName = formatFileName(listFile[i]);
            LevelButton levelButton = new LevelButton(new MapFile(fileName).load(), LevelButton.PREFIX + (i + 1));
            levelButtons.add(levelButton);
        }
    }

    public int getSize() {
        return levelButtons.size();
    }

    public List<LevelButton> getLevelButtons() {
        return levelButtons;
    }

    
}
