package ru.jdrm.jdrmapp.design.reviewratings;

import android.util.Pair;

public class RatingReview {
    private int maxBarValue;
    private String[] labels;
    private Pair[] colors;
    private int[] raters;

    public RatingReview(int maxBarValue, String[] labels, Pair[] colors, int[] raters) {
        this.maxBarValue = maxBarValue;
        this.labels = labels;
        this.colors = colors;
        this.raters = raters;
    }

    public int getMaxBarValue() {
        return maxBarValue;
    }

    public void setMaxBarValue(int maxBarValue) {
        this.maxBarValue = maxBarValue;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Pair[] getColors() {
        return colors;
    }

    public void setColors(Pair[] colors) {
        this.colors = colors;
    }

    public int[] getRaters() {
        return raters;
    }

    public void setRaters(int[] raters) {
        this.raters = raters;
    }

}
