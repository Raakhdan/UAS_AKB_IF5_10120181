package com.example.UAS_AKB_IF5_10120181;

//Akhdan Rafly
//10120181
//IF-5

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Note> notes;

    Adapter(Context context, List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_view,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String title = notes.get(position).getTitle();
        String category = notes.get(position).getCategory();
        String date = notes.get(position).getDate();
        String time = notes.get(position).getTime();
        viewHolder.nTitle.setText(title);
        viewHolder.nCategory.setText(category);
        viewHolder.nDate.setText(date);
        viewHolder.nTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView nTitle,nCategory, nDate, nTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nTitle =itemView.findViewById(R.id.nTitle);
            nCategory = itemView.findViewById(R.id.nCategory);
            nDate = itemView.findViewById(R.id.nDate);
            nTime = itemView.findViewById(R.id.nTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                    intent.putExtra("ID",notes.get(getAdapterPosition()).getID());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
// Akhdan Rafly
// 10120181
// IF-5
