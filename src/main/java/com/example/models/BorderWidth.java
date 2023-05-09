package com.example.models;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

public enum BorderWidth {
    BOTTOM_RIGHT(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0, 1, 1, 0)))),
    TOP_RIGHT_BOTTOM(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 0)))),
    FULL(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1, 1, 1, 1)))),
    RIGHT_BOTTOM_LEFT(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0, 1, 1, 1))));

    private final Border border;

    BorderWidth(Border border) {
        this.border = border;
    }

    public Border getBorder() {
        return this.border;
    }

}
