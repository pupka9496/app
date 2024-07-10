package ru.jdrm.jdrmapp.design.Event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;
import java.util.List;

public class EventA extends RecyclerView.Adapter<EventVH> {
    private final List<EventC> dataEventList;

    public EventA(List<EventC> dataEventList) {
        this.dataEventList = dataEventList;
    }

    @NonNull
    @Override
    public EventVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent,false);
        return new EventVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventVH holder, int position) {
        holder.name_event.setText(dataEventList.get(position).getTitle());
        holder.event_description.setText(dataEventList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return dataEventList.size();
    }
}
