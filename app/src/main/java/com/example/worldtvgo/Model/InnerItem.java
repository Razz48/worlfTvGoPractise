package com.example.worldtvgo.Model;

public class InnerItem {

    private final int imageResId;
    private final int imageSmallResId;

    private final int imageLogo;

    private final String language;

    private final String playing;

    private final String showName;

    private final int showChannel;

    private final String channelName;
    private final int views;

    public InnerItem(int imageResId, int imageSmallResId, int imageLogo, String language, String playing, String showName, int showChannel, String channelName, int views) {
        this.imageResId = imageResId;
        this.imageSmallResId = imageSmallResId;
        this.imageLogo = imageLogo;
        this.language = language;
        this.playing = playing;
        this.showName = showName;
        this.showChannel = showChannel;
        this.channelName = channelName;
        this.views = views;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getImageSmallResId() {
        return imageSmallResId;
    }

    public int getImageLogo() {
        return imageLogo;
    }

    public String getLanguage() {
        return language;
    }

    public String getPlaying() {
        return playing;
    }

    public String getShowName() {
        return showName;
    }

    public int getShowChannel() {
        return showChannel;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getViews() {
        return views;
    }
}

