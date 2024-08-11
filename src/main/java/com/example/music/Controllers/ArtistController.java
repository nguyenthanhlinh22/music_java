package com.example.music.Controllers;

import com.example.music.Models.ArtistModel;
import com.example.music.Services.ArtistService;
import com.example.music.Services.SongService;
import com.example.music.entity.Artist;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name ="ArtistController", urlPatterns = "/artist/*")
public class ArtistController extends HttpServlet {
    private ArtistService artistService;
    private SongService songService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.artistService = new ArtistService();
        this.songService = new SongService();
        }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if(url == null || url.equals("/")){
            try {
                this.songService.renderListSong(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            switch (url){
                case "/artist":
                    try {
                        this.artistService.renderListArtists(req, resp);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }
}
