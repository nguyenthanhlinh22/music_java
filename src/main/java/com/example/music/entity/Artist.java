package com.example.music.entity;

public class Artist {
    private int Artistsid;  // Removed static keyword
    private String Artistname;
    private int Artistimage;
    private String gender;
    private String description;

    // Full constructor
    public Artist( String Artistname, int Artistimage, String gender, String description) {

        this.Artistname = Artistname;
        this.Artistimage = Artistimage;
        this.gender = gender;
        this.description = description;

    }
    public Artist(int Artistsid , String Artistname, int Artistimage, String gender, String description ) {
        this.Artistsid = Artistsid;
        this.Artistname = Artistname;
        this.Artistimage = Artistimage;
        this.gender = gender;
        this.description = description;
    }

    // Constructor for just artist name (and ID if needed)
    public Artist(String artistname) {
        this.Artistname = artistname;
    }

    // Getters and Setters
    public int getArtistsid() {
        return Artistsid;
    }

    public void setArtistsid(int artistsid) {
        this.Artistsid = artistsid;
    }

    public String getArtistname() {
        return Artistname;
    }

    public void setArtistname(String artistname) {
        this.Artistname = artistname;
    }

    public int getArtistimage() {
        return Artistimage;
    }

    public void setArtistimage(int artistimage) {
        this.Artistimage = artistimage;
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



}
