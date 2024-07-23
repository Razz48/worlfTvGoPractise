package com.example.worldtvgo;

import java.io.Serializable;

public class Channel implements Serializable {

    private String name;
    private int channelId;
    private int logoResId;
    private String currentlyPlaying;
    private String nextShow;

    private String category;
    private  int poster;
    private String videoUrl;

    public Channel(String name, int channelId, int logoResId, String currentlyPlaying, String nextShow,String category,int poster,String videoUrl) {
        this.name = name;
        this.channelId = channelId;
        this.logoResId = logoResId;
        this.currentlyPlaying = currentlyPlaying;
        this.nextShow = nextShow;
        this.category=category;
        this.poster=poster;
        this.videoUrl=videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getLogoResId() {
        return logoResId;
    }

    public void setLogoResId(int logoResId) {
        this.logoResId = logoResId;
    }

    public String getCurrentlyPlaying() {
        return currentlyPlaying;
    }

    public void setCurrentlyPlaying(String currentlyPlaying) {
        this.currentlyPlaying = currentlyPlaying;
    }

    public String getNextShow() {
        return nextShow;
    }

    public void setNextShow(String nextShow) {
        this.nextShow = nextShow;
    }
}
