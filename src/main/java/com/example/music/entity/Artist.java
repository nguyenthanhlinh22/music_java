package com.example.music.entity;

public class Artist {
    private static int Artistsid;
    private String Artistname;
    private int Artistimage;
    private String gender;
    private String description;
    private int Songid;


    public Artist(String Artistname, int Artistimage, String gender, String description, int Songid) {
        this.Artistsid = Artistsid;
        this.Artistname = Artistname;
        this.Artistimage = Artistimage;
        this.gender = gender;
        this.description = description;
        this.Songid = Songid;

    }

    public int getArtistsid() {
        return Artistsid;
    }

    public static void setArtistsid(int artistsid) {
        Artistsid = artistsid;
    }

    public String getArtistname() {
        return Artistname;
    }

    public void setArtistname(String artistname) {
        Artistname = artistname;
    }

    public int getArtistimage() {
        return Artistimage;
    }

    public void setArtistimage(int artistimage) {
        Artistimage = artistimage;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSongid() {
        return Songid;
    }

    public void setSongid(int songid) {
        Songid = songid;
    }
}
