package ru.jdrm.jdrmapp.design.reviewratings;

/**
 * Bar represent the single unit bar of the star rating system.
 */

public class Bar {
    private String starLabel;
    private int raters;
    private int color;
    private int startColor;
    private int endColor;

    public Bar() {
    }

    public int getRaters() {
        return raters;
    }

    public void setRaters(int raters) {
        this.raters = raters;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getStarLabel() {
        return starLabel;
    }

    public void setStarLabel(String starLabel) {
        this.starLabel = starLabel;
    }

    public int getEndColor() {
        return endColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }

    public boolean isGradientBar() {
        return endColor != 0;
    }

    public int getStartColor() {
        return startColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }
}
