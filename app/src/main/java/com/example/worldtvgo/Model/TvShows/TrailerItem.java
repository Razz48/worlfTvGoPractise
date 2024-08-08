package com.example.worldtvgo.Model.TvShows;

public class TrailerItem{

    private int imageResId;
    String showDetail;
    String sample;

    public TrailerItem(String showDetail, String sample,int imageResId) {
        this.showDetail = showDetail;
        this.sample = sample;
        this.imageResId=imageResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getShowDetail() {
        return showDetail;
    }

    public void setShowDetail(String showDetail) {
        this.showDetail = showDetail;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }
}
