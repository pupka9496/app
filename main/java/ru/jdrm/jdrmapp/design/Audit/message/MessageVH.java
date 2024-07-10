package ru.jdrm.jdrmapp.design.Audit.message;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;

public class MessageVH extends RecyclerView.ViewHolder {
    public final TextView message;
    public final View parentView;

    public MessageVH(@NonNull View itemView) {
        super(itemView);
        parentView = itemView.findViewById(R.id.cardView1);
        message = itemView.findViewById(R.id.messagetext);

    }
}
