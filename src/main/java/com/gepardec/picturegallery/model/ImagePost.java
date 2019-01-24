package com.gepardec.picturegallery.model;

import java.io.Serializable;

public class ImagePost implements Serializable {
    private String title;
    private String image;

    public ImagePost() {
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ImagePost{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
