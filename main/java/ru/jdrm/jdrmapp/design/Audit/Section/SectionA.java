package ru.jdrm.jdrmapp.design.Audit.Section;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.R;


public class SectionA extends RecyclerView.Adapter<SectionVH> {
    Context context;
    private final ArrayList<SectionC> dataSections;
    private final OnItemListener onItemListener;

    public SectionA(Context context, ArrayList<SectionC> dataSections, OnItemListener onItemListener) {
        this.context = context;
        this.dataSections = dataSections;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public SectionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View sectionView = LayoutInflater.from(context).inflate(R.layout.section_item, parent,false);
        return new SectionVH(sectionView, onItemListener, dataSections);
    }

    @Override
    public void onBindViewHolder(@NonNull SectionVH holder, int position) {
        holder.name_section.setText(dataSections.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataSections.size();
    }

    public interface  OnItemListener {
        void onItemClick(int position, SectionC dataSection);
    }
}
