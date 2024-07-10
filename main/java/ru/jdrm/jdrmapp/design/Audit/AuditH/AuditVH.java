package ru.jdrm.jdrmapp.design.Audit.AuditH;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.jdrm.jdrmapp.R;
import ru.jdrm.jdrmapp.design.Audit.Audit;

public class AuditVH extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView name_audit;
    CardView cardView;
    TextView audit_description;

    private final ArrayList<Audit> dataAuditList;
    private final AuditA.OnItemListener onItemListener;

    public AuditVH(@NonNull View itemView, AuditA.OnItemListener onItemListener, ArrayList<Audit> dataAuditList) {
        super(itemView);
        name_audit = itemView.findViewById(R.id.name_audit);
        cardView = itemView.findViewById(R.id.cardView);
        audit_description = itemView.findViewById(R.id.audit_description);
        itemView.setOnClickListener(this);
        this.onItemListener = onItemListener;
        this.dataAuditList = dataAuditList;
    }

    @Override
    public void onClick(View view){

        onItemListener.onItemClick(getAdapterPosition(), dataAuditList.get(getAdapterPosition()));
    }

}
