package com.example.music.Controllers;

import com.example.music.HelloServlet;
import com.example.music.Services.ArtistService;
import com.example.music.Services.CategoryService;
import com.example.music.Services.SongService;
import com.example.music.Services.StatusService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


@WebServlet(name = "SongController", urlPatterns = "/songs/*")
public class SongController extends HelloServlet {
    private SongService songService;
    private CategoryService categoryService;
    private ArtistService artistService;
    private StatusService statusService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.songService = new SongService();
        this.categoryService = new CategoryService();
        this.artistService = new ArtistService();
        this.statusService = new StatusService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = request.getPathInfo();
        System.out.println(url);
        if (url == null || url.equals("/")) {
            try {
                this.songService.renderListSong(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        switch (url) {
            case "/delete":
                try {
                    this.songService.deleteSong(request, response);
                    response.sendRedirect("/songs");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/create":
                try {
                    this.songService.renderPageCreate(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/update":
                try {
                    this.songService.renderPageUpdate(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/search" :
                try {
                    this.songService.renderSeachSong(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if (url == null || url.equals("/")) {
            try {
                this.songService.renderListSong(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        switch (url){
            case "/create":
                try {
                    this.songService.createSong(req, resp);
                    resp.sendRedirect("/songs");
                } catch (SQLException | ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/update":
                try {
                    this.songService.updateSongs(req, resp);
                    resp.sendRedirect("/songs");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

        }


    }
}
