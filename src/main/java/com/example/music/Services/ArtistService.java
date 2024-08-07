package com.example.music.Services;

import com.example.music.Models.ArtistModel;
import com.example.music.entity.Artist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistService {
    private ArtistModel artistModel;


    public ArtistService() {
        this.artistModel = new ArtistModel();
    }

    public List<Artist> getAllArtists() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        ResultSet resultSet = this.artistModel.getAllArtists();
        while (resultSet.next()) {
            int Artistsid = resultSet.getInt("Artistsid");
            String Artistsname = resultSet.getString("Artistsname");
            int Artistsage = resultSet.getInt("Artistsage");
            String gender = resultSet.getString("Gender");
            String description = resultSet.getString("Description");
            int Songid = resultSet.getInt("Songid");

            Artist artist = new Artist( Artistsname, Artistsage, gender, description, Songid);
            Artist.setArtistsid(Artistsid);
            artists.add(artist);
        }
        return artists;
    }
}
