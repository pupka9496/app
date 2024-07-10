package ru.jdrm.jdrmapp.design.Audit.Number;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.R;

public class NumberA extends RecyclerView.Adapter<NumberVH> {

    private final Context context;

    private final ArrayList<NumberC> dataMetrics;

    private final OnItemListener onItemListener;

    public NumberA(Context context, ArrayList<NumberC> dataMetrics, OnItemListener onItemListener) {
        this.context = context;
        this.dataMetrics = dataMetrics;
        this.onItemListener = onItemListener;
    }


    @NonNull
    @Override
    public NumberVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.section_item, parent,false);
        return new NumberVH(view, onItemListener, dataMetrics);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberVH holder, int position) {
        holder.name_section.setText(dataMetrics.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataMetrics.size();
    }

    public interface OnItemListener {
        void onItemClick(int position, NumberC dataMetric);
    }
}
