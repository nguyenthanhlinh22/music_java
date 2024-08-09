package com.example.music.Services;

import com.example.music.Models.SongModel;
import com.example.music.entity.Artist;
import com.example.music.entity.Category;
import com.example.music.entity.Song;
import com.example.music.entity.Status;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SongService {
    private final SongModel songModel;
    private final CategoryService categoryService;
    private final ArtistService artistService;
    private final StatusService statusService;


    public SongService() {
        this.songModel = new SongModel();
        this.categoryService = new CategoryService();
        this.artistService = new ArtistService();
        this.statusService = new StatusService();
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
            String ReleaseDate = resultSet.getString("ReleaseDate");
            int Artists_id = resultSet.getInt("Artists_id");
            String categoryname = resultSet.getString("categoryname");
            String artistname = resultSet.getString("Artistsname");
            String statusname = resultSet.getString("statusname");

            // Create Song object
            Song song = new Song(SongName, List_id, status_id, Category_id, ReleaseDate, Artists_id);
            song.setSongid(Songid);

            // Create and set Category object
            Category category = new Category(categoryname);
            category.setCategoryid(Category_id);
            song.setCategory(category);

            // Create and set Artist object
            Artist artist = new Artist(artistname);
            artist.setArtistsid(Artists_id);
            song.setArtist(artist);

            // Create and set Status object
            Status status = new Status(statusname);
            status.setStatusid(status_id);
            song.setStatus(status);

            // Add Song to list
            songs.add(song);
        }

        return songs;
    }

    // Chức năng
    public void deleteSong(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        int Songid = Integer.parseInt(req.getParameter("id"));
        this.songModel.destroySongs(Songid);

    }

    public void createSong(HttpServletRequest req, HttpServletResponse res) throws SQLException, ParseException {
        String songName = req.getParameter("SongName");
        int List_id = Integer.parseInt(req.getParameter("List_id"));
        int Status_id = Integer.parseInt(req.getParameter("Status_id"));
        int Category_id = Integer.parseInt(req.getParameter("Category_id"));
        String date = req.getParameter("ReleaseDate");
        int Artists_id = Integer.parseInt(req.getParameter("Artists_id"));
        System.out.println("Received ReleaseDate: " + date);
        System.out.println(Artists_id);

        Song song = new Song(songName, List_id, Status_id , Category_id, date, Artists_id);
        this.songModel.storeSong(song);
    }

    public Song getSongById(HttpServletRequest req) throws SQLException {
        int songid = Integer.parseInt(req.getParameter("id"));

        ResultSet resultSet = this.songModel.getSongs();
        Song song = null;
        while (resultSet.next()) {
            int Songid = resultSet.getInt("Songid");
            String SongName = resultSet.getString("SongName");
            int List_id = resultSet.getInt("List_id");
            int status_id = resultSet.getInt("Status_id");
            int Category_id = resultSet.getInt("Category_id");
            String ReleaseDate = resultSet.getString("ReleaseDate");
            int Artists_id = resultSet.getInt("Artists_id");
            String categoryname = resultSet.getString("categoryname");
            String artistname = resultSet.getString("Artistsname");
            String statusname = resultSet.getString("statusname");

            // Create Song object
            song = new Song(SongName, List_id, status_id, Category_id, ReleaseDate, Artists_id);
            song.setSongid(Songid);

            // Create and set Category object
            Category category = new Category(categoryname);
            category.setCategoryid(Category_id);
            song.setCategory(category);

            // Create and set Artist object
            Artist artist = new Artist(artistname);
            artist.setArtistsid(Artists_id);
            song.setArtist(artist);

            // Create and set Status object
            Status status = new Status(statusname);
            status.setStatusid(status_id);
            song.setStatus(status);

        }

        return song;



    }





    //Render Page
    public void renderListSong(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Song> songs = this.getAllSongs();
        req.setAttribute("songs", songs);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/songs/list.jsp");
        requestDispatcher.forward(req, res);
    }

    public void renderPageCreate(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Category> categories = this.categoryService.getAllcategories();
        List<Artist> artists = this.artistService.getAllArtists();
        List<Status> statuses = this.statusService.getAllStatus();

        req.setAttribute("categories", categories);
        req.setAttribute("artists", artists);
        req.setAttribute("statuses", statuses);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/songs/create.jsp");
        requestDispatcher.forward(req, res);


    }

    public void renderPageUpdate(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        Song song = this.getSongById(req);
        List<Category> categories = this.categoryService.getAllcategories();
        List<Artist> artists = this.artistService.getAllArtists();
        List<Status> statuses = this.statusService.getAllStatus();
        req.setAttribute("song", song); // Set song attribute
        req.setAttribute("categories", categories);
        req.setAttribute("artists", artists);
        req.setAttribute("statuses", statuses);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/songs/update.jsp");
        requestDispatcher.forward(req, res);
    }

}
