package ru.jdrm.jdrmapp.design.Event.EventNav;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;

import java.util.List;

public class EventNavA extends RecyclerView.Adapter<EventNavVH> {
    private final List<EventNavC> dataEventNavList;

    public EventNavA(List<EventNavC> dataEventNavList) {
        this.dataEventNavList = dataEventNavList;
    }

    @NonNull
    @Override
    public EventNavVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_item, parent,false);
        return new EventNavVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull EventNavVH holder, int position) {
        holder.name_metric.setText(dataEventNavList.get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        return dataEventNavList.size();
    }
}
