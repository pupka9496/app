package ru.jdrm.jdrmapp.design.Diagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;

import java.util.List;

public class DiagramA extends RecyclerView.Adapter<DiagramVH> {
    private final List<DiagramC> dataClassList;

    public DiagramA(List<DiagramC> dataClassList) {
        this.dataClassList = dataClassList;
    }
    @NonNull
    @Override
    public DiagramVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_score, parent,false);
        return new DiagramVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiagramVH holder, int position) {
        holder.metric_name.setText(dataClassList.get(position).getTitle());
        holder.rating_reviews.createRatingBars(dataClassList.get(position).getDiagram());

    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }

}