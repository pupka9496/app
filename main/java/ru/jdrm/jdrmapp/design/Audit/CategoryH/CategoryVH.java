package ru.jdrm.jdrmapp.design.Audit.CategoryH;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.R;

public class CategoryVH extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView numberPP;
    CardView cardView;

    private final ArrayList<CategoryC> dataMetric;
    private final CategoryA.OnItemListener onItemListener;

    public CategoryVH(@NonNull View itemView, CategoryA.OnItemListener onItemListener, ArrayList<CategoryC> dataMetrics) {
        super(itemView);
        numberPP = itemView.findViewById(R.id.numberPP);
        cardView = itemView.findViewById(R.id.cardView);
        this.dataMetric = dataMetrics;
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        onItemListener.onItemClick(getAdapterPosition(), dataMetric.get(getAdapterPosition()));

    }
}
