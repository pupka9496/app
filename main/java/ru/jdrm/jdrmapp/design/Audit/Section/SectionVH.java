package ru.jdrm.jdrmapp.design.Audit.Section;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.R;

public class SectionVH extends RecyclerView.ViewHolder implements  View.OnClickListener{
    TextView name_section;
    CardView cardView;
    private final ArrayList<SectionC> dataSections;
    private final SectionA.OnItemListener onItemListener;

    public SectionVH(@NonNull View itemView, SectionA.OnItemListener onItemListener, ArrayList<SectionC> dataSections) {
        super(itemView);
        name_section = itemView.findViewById(R.id.name_section);
        cardView = itemView.findViewById(R.id.cardView);
        this.onItemListener = onItemListener;
        itemView.setOnClickListener(this);
        this.dataSections = dataSections;
    }

    @Override
    public void onClick(View view){
        onItemListener.onItemClick(getAdapterPosition(), dataSections.get(getAdapterPosition()));
    }

}
