package com.example.models;

public class GameResultChecker {
    private NonogramBoard nonogramBoard;
    private HeartModel heartModel;
    
    public static String WIN_TITLE      = "Chúc Mừng !!!";
    public static String WIN_CONTENT    = "Bạn đã thắng trò chơi";
    public static String LOSE_TITLE     = "Rất tiếc !!!";
    public static String LOSE_CONTENT   = "Bạn đã hết số lần chơi";

    public GameResultChecker(NonogramBoard nonogramBoard, HeartModel heartModel) {
        this.nonogramBoard = nonogramBoard;
        this.heartModel = heartModel;
    }

    public boolean isWin() {
        return nonogramBoard.isGridStateHaveNoFreeValue();
    }

    public boolean isLose() {
        return heartModel.isQuantityEqualZero();
    }
}
