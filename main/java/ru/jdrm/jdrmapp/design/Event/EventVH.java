package ru.jdrm.jdrmapp.design.Event;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;

public class EventVH extends RecyclerView.ViewHolder {
    TextView name_event;
    CardView cardView;
    TextView event_description;
    public EventVH(@NonNull View itemView) {
        super(itemView);
        name_event = itemView.findViewById(R.id.name_event);
        cardView = itemView.findViewById(R.id.cardView);
        event_description = itemView.findViewById(R.id.event_description);
    }
}
