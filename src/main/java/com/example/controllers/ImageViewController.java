package com.example.controllers;

import com.example.models.HeartModel;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewController implements InvalidationListener {
    private HeartModel heartModel;
    private ImageView[] imageViews;

    public ImageViewController(HeartModel heartModel, ImageView[] imageViews) {
        this.heartModel = heartModel;
        this.imageViews = imageViews;
        this.heartModel.addListener(this);
    }

    public void initialize() {
        renderImageView();
    }

    private void renderImageView() {
        System.out.println(heartModel.getHearts().length);
        for(int i = 0; i < heartModel.getHearts().length; i++) {
            imageViews[i].setImage(new Image(heartModel.getHeartImageAt(i)));
        }
    }

    @Override
    public void invalidated(Observable observable) {
        renderImageView();
    }

}
