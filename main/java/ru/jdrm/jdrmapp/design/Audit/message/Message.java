package ru.jdrm.jdrmapp.design.Audit.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.jdrm.jdrmapp.R;


public class Message extends RecyclerView.Adapter<MessageVH> {
    Context context;
    String Text;

    public Message(Context context, String Text) {
        this.context = context;
        this.Text = Text;
    }

    @NonNull
    @Override
    public MessageVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View messageItems = LayoutInflater.from(context).inflate(R.layout.message, parent, false);

        return new MessageVH(messageItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageVH holder, int position) {
        holder.message.setText(Text);
    }


    @Override
    public int getItemCount() {
        return 1;
    }

}
