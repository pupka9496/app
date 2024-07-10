package ru.jdrm.jdrmapp.design.Diagram;


import ru.jdrm.jdrmapp.design.reviewratings.RatingReview;

public class DiagramC {
    private int Title;
    private RatingReview Diagram;

    public DiagramC(int Title,
                    RatingReview Diagram) {
        this.Title = Title;
        this.Diagram = Diagram;

    }

    public int getTitle() {
        return Title;
    }

    public void setTitle(int title) {
        Title = title;
    }

    public RatingReview getDiagram() {
        return Diagram;
    }

}