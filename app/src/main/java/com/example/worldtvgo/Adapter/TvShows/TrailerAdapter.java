package com.example.worldtvgo.Adapter.TvShows;// TrailerAdapter.java
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.Model.TvShows.TrailerItem;
import com.example.worldtvgo.R;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {

    private Context context;
    private List<TrailerItem> trailerList;
    boolean isShimmer=true;

    public TrailerAdapter(Context context, List<TrailerItem> trailerList,boolean isShimmer) {
        this.context = context;
        this.trailerList = trailerList;
        this.isShimmer=isShimmer;
    }

    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isShimmer) {
            view = LayoutInflater.from(context).inflate(R.layout.trailer_preview_item_shimmer, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.trailer_preview_item, parent, false);
        }
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, int position) {
        if (!isShimmer) {
            TrailerItem item = trailerList.get(position);
            holder.trailerImage.setImageResource(item.getImageResId());
            holder.trailerTitle.setText(item.getShowDetail());
            holder.trailerSubtitle.setText(item.getSample());
        }
    }

    @Override
    public int getItemCount() {
        return trailerList.size();
    }

    public static class TrailerViewHolder extends RecyclerView.ViewHolder {

        ImageView trailerImage;
        TextView trailerTitle;
        TextView trailerSubtitle;

        public TrailerViewHolder(@NonNull View itemView) {
            super(itemView);
            trailerImage = itemView.findViewById(R.id.trailer_image);
            trailerTitle = itemView.findViewById(R.id.trailer_title);
            trailerSubtitle = itemView.findViewById(R.id.trailer_subtitle);
        }
    }
}
