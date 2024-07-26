package com.example.worldtvgo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.Model.Channel;
import com.example.worldtvgo.R;

import java.util.List;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> {

    Context context;
    private List<Channel> channels;
    private final OnChannelClickListner listner;
    private int selectedPosition = RecyclerView.NO_POSITION;

    public interface OnChannelClickListner{
        void onChannelClick(Channel channel);
    }

    public ChannelListAdapter(List<Channel> channels, OnChannelClickListner listner, Context context) {
        this.channels = channels;
        this.listner = listner;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_channel,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Channel channel=channels.get(position);
        holder.bind(channel, position == selectedPosition);

    }

    @Override
    public int getItemCount() {
        return channels.size() ;
    }


    public void updateChannels(List<Channel> newChannels) {
        this.channels = newChannels;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView channelLogo;
        TextView channelName;
        TextView channelId;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            channelLogo=(ImageView) itemView.findViewById(R.id.channel_logo);
            channelName=(TextView) itemView.findViewById(R.id.channel_name);
            channelId=(TextView) itemView.findViewById(R.id.channel_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION && listner!=null){
                        listner.onChannelClick(channels.get(position));
                        notifyItemChanged(selectedPosition);
                        selectedPosition=position;
                        notifyItemChanged(selectedPosition);
                    }
                }
            });
        }

        public void bind(Channel channel,boolean isSelected){
            channelName.setText(channel.getName());
            channelLogo.setImageResource(channel.getLogoResId());
            channelId.setText(String.valueOf(channel.getChannelId()));
            itemView.setSelected(isSelected);
        }
    }

}
