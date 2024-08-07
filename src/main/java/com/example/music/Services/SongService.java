package com.example.music.Services;

import com.example.music.Models.SongModel;
import com.example.music.entity.Song;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongService {
    private SongModel songModel;

    public SongService() {
        this.songModel = new SongModel();
    }

    public List<Song> getAllSongs() throws SQLException {
        List<Song> songs = new ArrayList<>();
        ResultSet resultSet = this.songModel.getSongs();
        while (resultSet.next()) {
            int Songid = resultSet.getInt("Songid");
            String SongName = resultSet.getString("SongName");
            int List_id = resultSet.getInt("List_id");
            int status_id = resultSet.getInt("Status_id");
            int Category_id = resultSet.getInt("Category_id");
            Date ReleaseDate = resultSet.getDate("ReleaseDate");
            int Artists_id = resultSet.getInt("Artists_id");

            Song song = new Song(SongName, List_id, status_id, Category_id, ReleaseDate, Artists_id);
            song.setSongid(Songid);
            songs.add(song);
            System.out.println(song.getSongName());



        }
        return songs;
    }

    public void renderListSong(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Song> songs =this.getAllSongs();
        req.setAttribute("songs", songs);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/songs/list.jsp");
        requestDispatcher.forward(req, res);
    }
}
