package com.example.controllers;

import java.util.Optional;

import com.example.App;
import com.example.models.BorderWidth;
import com.example.models.GameResultChecker;
import com.example.models.HeartModel;
import com.example.models.ImgFile;
import com.example.models.NonogramBoard;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class GridController implements InvalidationListener {
    private GridPane gridPane;
    private NonogramBoard nonogramBoard;
    private HeartModel heartModel;
    private Button[][] buttons;

    private MenuController menuController;

    public GridController(GridPane gridPane, NonogramBoard nonogramBoard, HeartModel heartModel, MenuController menuController) {
        this.gridPane = gridPane;
        this.nonogramBoard = nonogramBoard;
        this.heartModel = heartModel;
        this.buttons = new Button[nonogramBoard.getNumRows()][nonogramBoard.getNumCols()];
        this.menuController = menuController;
        this.nonogramBoard.addListener(this);
    }

    public NonogramBoard getNonogramBoard() {
        return nonogramBoard;
    }

    public void setNonogramBoard(NonogramBoard nonogramBoard) {
        this.nonogramBoard = nonogramBoard;
    }

    private void buttonHandle(int row, int col) {
        int value = nonogramBoard.isSquare() ? NonogramBoard.SQUARE_VALUE : NonogramBoard.MARK_VALUE;
        boolean isCanSetGridState = nonogramBoard.trySetGridState(row, col, value);
        if (isCanSetGridState) {
            nonogramBoard.setGridState(row, col, value);
            if (nonogramBoard.isRowFullSquare(row))
                nonogramBoard.markFullRow(row);

            if (nonogramBoard.isColFullSquare(col))
                nonogramBoard.markFullCol(col);
        } else {
            int realCellValue = nonogramBoard.getBoard()[row][col];
            nonogramBoard.setGridState(row, col, realCellValue);
            heartModel.minusOne();
        }
        checkGameResult();
    }

    private void checkGameResult() {
        GameResultChecker checker = new GameResultChecker(nonogramBoard, heartModel);
        if(checker.isWin())
            showDialog(GameResultChecker.WIN_TITLE, GameResultChecker.WIN_CONTENT, "Bạn có muốn chơi lại?");
        if(checker.isLose())                        
            showDialog(GameResultChecker.LOSE_TITLE, GameResultChecker.LOSE_CONTENT, "Bạn có muốn chơi lại?");
    }

    private void setButtonBorder(Button button, BorderWidth borderWidth) {
        button.setBorder(borderWidth.getBorder());
    }

    private void initializeGridButton(Button button, int row, int col) {
        String noBackgroundStyle = "-fx-background-color: #fff";
        button.setStyle(noBackgroundStyle);
        if (row == 0 && col == 0)
            setButtonBorder(button, BorderWidth.FULL);
        else if (row == 0)
            setButtonBorder(button, BorderWidth.TOP_RIGHT_BOTTOM);
        else if (col == 0)
            setButtonBorder(button, BorderWidth.RIGHT_BOTTOM_LEFT);
        else
            setButtonBorder(button, BorderWidth.BOTTOM_RIGHT);
    }

    public void reinitializeGame() {
        nonogramBoard.reinitGridState();
        heartModel.reinitialize();
    }

    private void showDialog(String title, String headerText, String contentText) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        ButtonType playAgainButton = new ButtonType("Chơi lại", ButtonData.YES);
        ButtonType exitButton = new ButtonType("Thoát", ButtonData.NO);

        alert.getButtonTypes().setAll(playAgainButton, exitButton);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get().equals(playAgainButton))
            reinitializeGame();
        else menuController.closeGame();
    }

    public void initialize() {
        gridPane.setPrefSize(App.GRID_SIZE, App.GRID_SIZE);
        int numRow = nonogramBoard.getNumRows();
        int numCol = nonogramBoard.getNumCols();
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                final int row = i;
                final int col = j;
                Button button = new Button();
                button.setPrefSize(App.GRID_SIZE / (double) numRow, App.GRID_SIZE / (double) numCol);
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                initializeGridButton(button, row, col);

                button.setOnMousePressed(event -> {
                    buttonHandle(row, col);
                });

                GridPane.setHgrow(button, Priority.ALWAYS);
                GridPane.setVgrow(button, Priority.ALWAYS);
                gridPane.add(button, j, i); // Cột trước hàng sau
                buttons[i][j] = button;
            }
        }
    }

    @Override
    public void invalidated(Observable observable) {
        if (observable instanceof NonogramBoard) {
            NonogramBoard board = (NonogramBoard) observable;
            int row = board.getCurrentRow();
            int col = board.getCurrentCol();
            int value = board.getGridState()[row][col];

            if (value == NonogramBoard.SQUARE_VALUE)
                buttons[row][col]
                        .setStyle("-fx-background-color: #555");
            else if(value == NonogramBoard.MARK_VALUE) {
                try {
                    String markFilePath = new ImgFile("x_mark_2").load();
                    buttons[row][col].setStyle(
                            "-fx-background-image:  url('" + markFilePath + "');" +
                                    "-fx-background-size:  contain; " +
                                    "-fx-background-repeat:  no-repeat; " +
                                    "-fx-background-position: center");
                }

                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            else {
                initializeGridButton(buttons[row][col], row, col);
            }
        }
    }
}
