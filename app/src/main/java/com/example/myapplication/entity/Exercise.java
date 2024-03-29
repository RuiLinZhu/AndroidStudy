package com.example.myapplication.entity;

import java.io.Serializable;

public class Exercise implements Serializable {
    private int id;
    private String title;
    private String subTitle;
    private int background;
    private String bgColor; //题目标题的背景

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", background=" + background +
                '}';
    }
}
