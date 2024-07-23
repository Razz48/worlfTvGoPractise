package com.example.worldtvgo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.ExoPlayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.worldtvgo.databinding.FragmentChannelDetailBinding;


public class ChannelDetailFragment extends Fragment {
    FragmentChannelDetailBinding channelDetailBinding;
    ExoPlayer exoPlayer;

    public static ChannelDetailFragment newInstance(Channel channel) {
        ChannelDetailFragment fragment=new ChannelDetailFragment();
        Bundle args=new Bundle();
        args.putSerializable("channel",channel);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        channelDetailBinding=FragmentChannelDetailBinding.inflate(getLayoutInflater());
        View view=channelDetailBinding.getRoot();





//        if(getArguments()!=null){
//            Channel channel=(Channel) getArguments().getSerializable("channel");
//            channelDetailBinding.showTitle.setText(channel.getCurrentlyPlaying());
//            channelDetailBinding.nextShowTitle.setText(channel.getNextShow());
//            channelDetailBinding.backgroundImage.setImageResource(channel.getPoster());
//
//        }


        return view;
    }
}