package com.example.worldtvgo.Model.TvList;

import java.util.List;

public class Item {
    private int id;
    private String title;
    private String type;
    private String image_url;
    private List<String> genre;
    private String vendor_logo;
    private String vendor_name;
    private String watch_count;
    private int release_year;
    private int season_number;
    private int episode_number;
    private int total_season;
    private int total_episode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public String getVendor_logo() {
        return vendor_logo;
    }

    public void setVendor_logo(String vendor_logo) {
        this.vendor_logo = vendor_logo;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getWatch_count() {
        return watch_count;
    }

    public void setWatch_count(String watch_count) {
        this.watch_count = watch_count;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getSeason_number() {
        return season_number;
    }

    public void setSeason_number(int season_number) {
        this.season_number = season_number;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public int getTotal_season() {
        return total_season;
    }

    public void setTotal_season(int total_season) {
        this.total_season = total_season;
    }

    public int getTotal_episode() {
        return total_episode;
    }

    public void setTotal_episode(int total_episode) {
        this.total_episode = total_episode;
    }
}

