package com.example.worldtvgo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.worldtvgo.Model.InnerItem;
import com.example.worldtvgo.R;

import java.util.List;

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.ViewHolder> {
    List<InnerItem> innerItems;
    Context context;

    public InnerAdapter(List<InnerItem> innerItems,Context context) {
        this.innerItems = innerItems;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_inside,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InnerItem innerItem=innerItems.get(position);
        holder.language.setText(innerItem.getLanguage());
        holder.title.setText(innerItem.getShowName());
        holder.views.setText(String.valueOf(innerItem.getViews()));
        holder.playing.setText(innerItem.getPlaying());
        holder.channelName.setText(innerItem.getChannelName());
        Glide.with(context).load(innerItem.getImageResId()).into(holder.imageBig);
        Glide.with(context).load(innerItem.getImageSmallResId()).into(holder.imageSmall);

        Glide.with(context).load(innerItem.getShowChannel()).into(holder.youtubeIcon);

    }

    @Override
    public int getItemCount() {
        return innerItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageBig,imageSmall,youtubeIcon,logo;
        TextView language,title,views,playing,channelName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageBig=(ImageView) itemView.findViewById(R.id.recycler_image);
            imageSmall=(ImageView) itemView.findViewById(R.id.recycler_image_small);
            youtubeIcon=(ImageView) itemView.findViewById(R.id.youtube_imgfirst);
            language=(TextView) itemView.findViewById(R.id.language);
            playing=(TextView) itemView.findViewById(R.id.playing_now);
            title=(TextView) itemView.findViewById(R.id.show_title);
            logo=(ImageView) itemView.findViewById(R.id.season_txt);
            channelName=(TextView) itemView.findViewById(R.id.channel_name);
            views=(TextView) itemView.findViewById(R.id.view_text);
        }
    }
}
