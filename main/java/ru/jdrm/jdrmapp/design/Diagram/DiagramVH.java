package ru.jdrm.jdrmapp.design.Diagram;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;
import ru.jdrm.jdrmapp.design.reviewratings.RatingReviews;

public class DiagramVH extends RecyclerView.ViewHolder {
    TextView metric_name;
    CardView recCard;
    RatingReviews rating_reviews;
    public DiagramVH(@NonNull View itemView) {
        super(itemView);
        metric_name = itemView.findViewById(R.id.metric_name);
        recCard = itemView.findViewById(R.id.recCard);
        rating_reviews = itemView.findViewById(R.id.rating_reviews);
    }


}