package com.example.music.Services;

import com.example.music.Models.ArtistModel;
import com.example.music.entity.Artist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


            Artist artist = new Artist( Artistsname, Artistsage, gender, description);
            artist.setArtistsid(Artistsid);
            artists.add(artist);
        }
        return artists;
    }

    public void deleteArtists(HttpServletRequest request, HttpServletResponse res) throws SQLException {
        int Artistsid = Integer.parseInt(request.getParameter("id"));
        System.out.println(Artistsid);
        this.artistModel.destroyArtist(Artistsid);
    }


    public void renderListArtists(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Artist> artists = getAllArtists();
        request.setAttribute("artists", artists);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/artists/list.jsp");
        requestDispatcher.forward(request,response);

        }
}
