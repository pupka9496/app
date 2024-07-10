package ru.jdrm.jdrmapp.design.Event.EventNav;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;

public class EventNavVH extends RecyclerView.ViewHolder {

    TextView name_metric;
    CardView metricCardView;

    public EventNavVH(@NonNull View itemView) {
        super(itemView);
        name_metric = itemView.findViewById(R.id.name_metric);
        metricCardView = itemView.findViewById(R.id.metricCardView);
    }
}
