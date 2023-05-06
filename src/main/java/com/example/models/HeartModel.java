package com.example.models;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class HeartModel implements Observable {
    public static final int DEFAULT_QUANTITY = 3;
    private String heartFillUrl = new File("target/classes/com/example/img/heart.png").toURI().toString();
    private String heartOutlineUrl = new File("target/classes/com/example/img/heart_outline.png").toURI().toString();
    private int quantity;
    private String[] hearts;
    private List<InvalidationListener> listeners = new ArrayList<InvalidationListener>();

    public HeartModel(int quantity) {
        this.quantity = quantity;
        this.hearts = new String[quantity];
        for (int i = 0; i < hearts.length; i++)
            hearts[i] = heartFillUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void minusOne() {
        int oldValue = this.getQuantity();
        setQuantity(oldValue - 1);
        int newValue = this.getQuantity();
        hearts[newValue] = heartOutlineUrl;
        notifyAllListeners();
    }

    public String[] getHearts() {
        return hearts;
    }

    public void setHearts(String[] hearts) {
        this.hearts = hearts;
    }

    public static int getDefaultQuantity() {
        return DEFAULT_QUANTITY;
    }

    public String getHeartFillUrl() {
        return heartFillUrl;
    }

    public void setHeartFillUrl(String heartFillUrl) {
        this.heartFillUrl = heartFillUrl;
    }

    public String getHeartOutlineUrl() {
        return heartOutlineUrl;
    }

    public void setHeartOutlineUrl(String heartOutlineUrl) {
        this.heartOutlineUrl = heartOutlineUrl;
    }

    public String getHeartImageAt(int index) {
        return this.hearts[index];
    }

    @Override
    public void addListener(InvalidationListener arg0) {
        if(!listeners.contains(arg0))
            listeners.add(arg0);
    }

    @Override
    public void removeListener(InvalidationListener arg0) {
        if(listeners.contains(arg0))
            listeners.remove(arg0);
    }

    public void notifyAllListeners() {
        for(InvalidationListener listener : listeners)
            listener.invalidated(this);
    }
}
