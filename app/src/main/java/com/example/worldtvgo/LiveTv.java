package com.example.worldtvgo;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldtvgo.Adapter.CategoryListAdapter;
import com.example.worldtvgo.Adapter.ChannelListAdapter;
import com.example.worldtvgo.Model.Channel;
import com.example.worldtvgo.databinding.ActivityLiveTvListBinding;
import com.example.worldtvgo.databinding.CustomPlaybackControlViewBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public class LiveTv extends AppCompatActivity implements CategoryListAdapter.OnCategoryClickListner, ChannelListAdapter.OnChannelClickListner,View.OnClickListener {

    private List<Channel> allChannel;
    private ChannelListAdapter channelListAdapter;
    private List<String> categories;
    ExoPlayer exoPlayer;
    TextView showTitle,nextShowTitle;
    private boolean isCategorySelected = false;
    RecyclerView categoryRecyclerView;
    RecyclerView channelRecyclerView;
    CustomPlaybackControlViewBinding customPlaybackControlViewBinding;

    ActivityLiveTvListBinding liveTvListBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        liveTvListBinding = ActivityLiveTvListBinding.inflate(getLayoutInflater());
        View view = liveTvListBinding.getRoot();
        setContentView(view);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        liveTvListBinding.playerView.findViewById(R.id.pause).setOnClickListener(this);
        liveTvListBinding.playerView.findViewById(R.id.play).setOnClickListener(this);
        liveTvListBinding.playerView.findViewById(R.id.next).setOnClickListener(this);







        categories = Arrays.asList("ALL", "NEWS", "ENTERTAINMENT", "SONGS", "DRAMA", "ENGLISH", "NEPALI", "SCI FI", "SPRITUAL", "LOK");

        setCategory();
        setChannel();
        exoPlayer=new ExoPlayer.Builder(this).build();
        liveTvListBinding.playerView.setPlayer(exoPlayer);

        exoPlayer = new ExoPlayer.Builder(this).build();
        liveTvListBinding.playerView.setPlayer(exoPlayer);




        showTitle = liveTvListBinding.playerView.findViewById(R.id.show_title);
        nextShowTitle = liveTvListBinding.playerView.findViewById(R.id.next_show_title);








    }


    public void setCategory(){
        categoryRecyclerView=liveTvListBinding.playerView.findViewById(R.id.category_recycler_view);
        CategoryListAdapter categoryListAdapter=new CategoryListAdapter(categories,this);
        categoryRecyclerView.setAdapter(categoryListAdapter);

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    public void setChannel(){
        allChannel=getChannels();
        channelRecyclerView=liveTvListBinding.playerView.findViewById(R.id.channel_recycler_view);
        channelListAdapter=new ChannelListAdapter(allChannel, (ChannelListAdapter.OnChannelClickListner) this,getApplicationContext());
        channelRecyclerView.setAdapter(channelListAdapter);
        channelRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    @Override
    public void onChannelClick(Channel channel) {
    Uri videoUri=Uri.parse(channel.getVideoUrl());
    playVideo(videoUri);

    showTitle.setText(channel.getCurrentlyPlaying());
    nextShowTitle.setText(channel.getNextShow());


    }

    private void playVideo(Uri videoUrl){
        MediaItem mediaItem=MediaItem.fromUri(videoUrl);
        DefaultHttpDataSource.Factory httpDataSourceFactory=new DefaultHttpDataSource.Factory();
        MediaSource mediaSource=new ProgressiveMediaSource.Factory(httpDataSourceFactory).createMediaSource(mediaItem);

        exoPlayer.setMediaSource(mediaSource);
        liveTvListBinding.playerView.setKeepScreenOn(true);
        exoPlayer.prepare();
        exoPlayer.seekTo((int) exoPlayer.getCurrentPosition(), C.TIME_UNSET);
        exoPlayer.play();


    }

    private List<Channel> getChannels() {
        // Dummy data
        List<Channel> channels = new ArrayList<>();
        channels.add(new Channel("Fox", 001,R.drawable.fox, "Logan", "The Story with Martha Ma...","ALL",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"));
        channels.add(new Channel("ESPN", 002,R.drawable.espnimages, "IPL Live", "The Story with Martha Ma...","ALL",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
        channels.add(new Channel("Sony Television", 003,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","ALL",R.drawable.kapilsharmaposter,""));
        channels.add(new Channel("Kantipur", 004,R.drawable.kantipur_tv_hd, "Delta Bravo", "The Story with Martha Ma...","ALL",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"));
        channels.add(new Channel("HBO", 005,R.drawable.hbo, "Harry Potter", "The Story with Martha Ma...","ALL",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"));
        channels.add(new Channel("TLC", 006,R.drawable.tlc, "Cake Factory", "The Story with Martha Ma...","ALL",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","SONGS",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","LOK",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4"));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","SCI FI",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4"));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","ENTERTAINMENT",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4"));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","DRAMA",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/VolkswagenGTIReview.mp4"));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","ENGLISH",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4" ));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","NEPALI",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4" ));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","SPRITUAL",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
        channels.add(new Channel("Sony Television", 001,R.drawable.sony_tv_logo, "The Kapil Sharma Show", "The Story with Martha Ma...","SONGS",R.drawable.kapilsharmaposter,"http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"));
        return channels;
    }

    @Override
    public void onCategoryClick(String category) {
        isCategorySelected=!isCategorySelected;

        List<Channel> filteredChannels;

        if(categories.equals("ALL")){
            filteredChannels=allChannel;

        }else{
            filteredChannels=new ArrayList<>();
            for(Channel channel:allChannel){
                if(channel.getCategory().equals(category)){
                    filteredChannels.add(channel);
                }
            }
        }
         if (isCategorySelected) {
            channelRecyclerView.setVisibility(View.VISIBLE);
            channelListAdapter.updateChannels(filteredChannels);
             getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        } else {
            channelRecyclerView.setVisibility(View.GONE);

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(exoPlayer.isPlaying()){
            exoPlayer.stop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.setPlayWhenReady(false);
        exoPlayer.getPlaybackState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.getPlaybackState();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.getPlaybackState();
    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.pause){

            exoPlayer.pause();
            liveTvListBinding.playerView.findViewById(R.id.pause).setVisibility(View.GONE);
            liveTvListBinding.playerView.findViewById(R.id.play).setVisibility(View.VISIBLE);
        }

        if(id==R.id.play){
            exoPlayer.play();
            liveTvListBinding.playerView.findViewById(R.id.pause).setVisibility(View.VISIBLE);
            liveTvListBinding.playerView.findViewById(R.id.play).setVisibility(View.GONE);

        }

        if(id==R.id.next){

            long currentPosition=exoPlayer.getCurrentPosition();
            long newPosition=currentPosition+10000;
            exoPlayer.seekTo(newPosition);

        }
    }
}

//


