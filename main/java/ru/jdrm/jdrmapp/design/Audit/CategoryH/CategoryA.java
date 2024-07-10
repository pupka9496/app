package ru.jdrm.jdrmapp.design.Audit.CategoryH;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.R;


public class CategoryA extends RecyclerView.Adapter<CategoryVH> {

    private final Context context;
    private final ArrayList<CategoryC> dataMetrics;

    private final OnItemListener onItemListener;


    public CategoryA(Context context, ArrayList<CategoryC> dataMetrics, OnItemListener onItemListener) {
        this.context = context;
        this.dataMetrics = dataMetrics;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pp_item, parent,false);
        return new CategoryVH(view, onItemListener, dataMetrics);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {
        holder.numberPP.setText(dataMetrics.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataMetrics.size();
    }

    public interface  OnItemListener {
        void onItemClick(int position, CategoryC dataMetric);
    }
}
