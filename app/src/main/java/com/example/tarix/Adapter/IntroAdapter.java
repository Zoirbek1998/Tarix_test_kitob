package com.example.tarix.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarix.Model.Model;
import com.example.tarix.R;

import java.util.List;

public class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.IntroViewHolder> {

    Context context;
    List<Model> list;

    public IntroAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public IntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_list_into, parent, false);
        return new IntroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntroViewHolder holder, int position) {
        Model item=list.get(position);
        holder.imageView.setImageResource(item.getImage());
        holder.titel_bir.setText(item.getTitel1());
        holder.titel_ikki.setText(item.getTitel2());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class IntroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titel_bir, titel_ikki;

        public IntroViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.Image);
            titel_bir = itemView.findViewById(R.id.title_bir);
            titel_ikki = itemView.findViewById(R.id.title_ikki);

        }
    }
}
