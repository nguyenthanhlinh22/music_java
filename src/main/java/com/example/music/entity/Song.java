package com.example.music.entity;


public class Song {
    private int Songid;
    private String SongName;
    private int List_id;
    private int status_id;
    private int Category_id;
    private int Artists_id;
    private String ReleaseDate;
    private Status status;
    private Artist artist;  // Added
    private Category category;  // Added



    public Song(String SongName, int List_id, int status_id, int Category_id, String ReleaseDate, int Artists_id) {
        this.SongName = SongName;
        this.Artists_id = Artists_id;
        this.List_id = List_id;
        this.status_id = status_id;
        this.Category_id = Category_id;
        this.ReleaseDate = ReleaseDate;
    }



    public int getSongid() {
        return Songid;
    }

    public void setSongid(int songid) {
        Songid = songid;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public int getList_id() {
        return List_id;
    }

    public void setList_id(int list_id) {
        List_id = list_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int category_id) {
        Category_id = category_id;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Artist getArtist() {  // Added
        return artist;
    }

    public void setArtist(Artist artist) {  // Added
        this.artist = artist;
    }

    public Category getCategory() {  // Added
        return category;
    }

    public void setCategory(Category category) {  // Added
        this.category = category;
    }

    public int getArtists_id() {
        return Artists_id;
    }

    public void setArtists_id(int artists_id) {
        Artists_id = artists_id;
    }

}
