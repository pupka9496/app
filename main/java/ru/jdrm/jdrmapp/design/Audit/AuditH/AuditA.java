package ru.jdrm.jdrmapp.design.Audit.AuditH;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;
import ru.jdrm.jdrmapp.design.Audit.Audit;


import java.util.ArrayList;

public class AuditA extends RecyclerView.Adapter<AuditVH> {

    private final Context context;
    private final ArrayList<Audit> dataAuditList;
    private final OnItemListener onItemListener;

    public AuditA(Context context, ArrayList<Audit> dataAuditList, OnItemListener onItemListener) {
        this.context = context;
        this.dataAuditList = dataAuditList;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public AuditVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.audit_item, parent,false);
        return new AuditVH(view, onItemListener, dataAuditList);
    }

    @Override
    public void onBindViewHolder(@NonNull AuditVH holder, int position) {
        holder.name_audit.setText(dataAuditList.get(position).getTitle());
        holder.audit_description.setText(dataAuditList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataAuditList.size();
    }

    public interface  OnItemListener {
        void onItemClick(int position, Audit audit);
    }
}
