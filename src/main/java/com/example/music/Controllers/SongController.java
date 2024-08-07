package com.example.music.Controllers;

import com.example.music.HelloServlet;
import com.example.music.Services.SongService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "SongController", urlPatterns = "/songs/*")
public class SongController extends HelloServlet {
    private SongService songService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.songService = new SongService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = request.getPathInfo();
            if(url == null || url.equals("/")) {
                try {
                    this.songService.renderListSong(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }



    }
}
