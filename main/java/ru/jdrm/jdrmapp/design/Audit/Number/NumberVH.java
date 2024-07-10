package ru.jdrm.jdrmapp.design.Audit.Number;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.R;

public class NumberVH extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView cardView;
    TextView name_section;

    private final ArrayList<NumberC> dataMetric;

    private final NumberA.OnItemListener onItemListener;
    public NumberVH(@NonNull View itemView, NumberA.OnItemListener onItemListener, ArrayList<NumberC> dataMetrics) {
        super(itemView);
        name_section = itemView.findViewById(R.id.name_section);
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
