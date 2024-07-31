package com.example.worldtvgo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.Model.GenreItem;
import com.example.worldtvgo.R;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {

    private final List<GenreItem> genreItems;
    private final Context context;

    public GenreAdapter(List<GenreItem> genreItems, Context context) {
        this.genreItems = genreItems;
        this.context = context;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_by_genre_item, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        GenreItem genreItem = genreItems.get(position);
        holder.textView.setText(genreItem.getGenreName());
    }

    @Override
    public int getItemCount() {
        return genreItems.size();
    }

    public static class GenreViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.genre_img);
            textView = itemView.findViewById(R.id.genre_txt);
        }
    }
}
