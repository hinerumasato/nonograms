package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ToggleModel implements Observable {
    private boolean isOn; // Nếu on thì vuông, off thì X
    private List<InvalidationListener> listeners = new ArrayList<InvalidationListener>();

    public ToggleModel(boolean isOn) {
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
        notifyListeners();
    }

    @Override
    public void addListener(InvalidationListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        listeners.remove(listener);
    }

    public void notifyListeners() {
        for (InvalidationListener listener : listeners) {
            listener.invalidated(this);
        }
    }

}
