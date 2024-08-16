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
import java.util.ArrayList;
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

    public List<Song> getAllSongs(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Song> songs = new ArrayList<>();
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        ResultSet resultSet = null;

        try {
            if (page == null || limit == null) {
                // Fetch all songs if pagination parameters are not provided
                resultSet = this.songModel.getSongs();
            } else {
                // Fetch songs with pagination
                int intpage = Integer.parseInt(page);
                int intlimit = Integer.parseInt(limit);
                int offset = (intpage - 1) * intlimit;
                resultSet = this.songModel.getSongByOffset(offset, intlimit);
            }

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
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
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


        Song song = new Song(songName, List_id, Status_id , Category_id, date, Artists_id);
        this.songModel.storeSong(song);
    }

    public Song getSongById(HttpServletRequest req) throws SQLException {
        System.out.println(1);
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);

        ResultSet resultSet = this.songModel.getSongById(id);
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

    public void updateSongs(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
        try {
            // Retrieve parameters from request
            String songIdParam = req.getParameter("id");
            String songName = req.getParameter("SongName");
            String listIdParam = req.getParameter("List_id");
            String statusIdParam = req.getParameter("Status_id");
            String categoryIdParam = req.getParameter("Category_id");
            String releaseDate = req.getParameter("ReleaseDate");
            String artistIdParam = req.getParameter("Artists_id");

            // Validate and parse integers, handle missing or empty values
            int songId = parseInteger(songIdParam, "Song ID");
            int listId = parseInteger(listIdParam, "List ID");
            int statusId = parseInteger(statusIdParam, "Status ID");
            int categoryId = parseInteger(categoryIdParam, "Category ID");
            int artistId = parseInteger(artistIdParam, "Artist ID");

            // Create a Song object with the updated information
            Song song = new Song(songName, listId, statusId, categoryId, releaseDate, artistId);
            song.setSongid(songId);

            // Update song in the database
            this.songModel.updateSong(song);

        } catch (NumberFormatException e) {
            // Handle exception for invalid number format
            System.err.println("Error parsing integer values: " + e.getMessage());
            // Optionally: Set an error message in the request and forward to an error page or the same page
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format.");
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Database error: " + e.getMessage());
            // Optionally: Set an error message in the request and forward to an error page
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
        }
    }

    // Utility method to parse integers and handle empty strings
    private int parseInteger(String param, String paramName) throws NumberFormatException {
        if (param == null || param.trim().isEmpty()) {
            throw new NumberFormatException(paramName + " is missing or empty.");
        }
        return Integer.parseInt(param);
    }


    public List<Song> searchSongs(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        String keyword = req.getParameter("keyword");
        System.out.println(keyword);
        ResultSet resultSet = this.songModel.searchSongs(keyword);
        List<Song> songs = new ArrayList<>();
        while (resultSet.next()) {
            System.out.println(1);
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
            System.out.println(SongName);

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

            songs.add(song);
        }

        return songs;


    }





    //Render Page
    public void renderListSong(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Song> songs = this.getAllSongs(req, res);
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

    public void renderSeachSong(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        List<Song> songs = this.searchSongs(req, res);
        req.setAttribute("songs", songs);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/songs/list.jsp");
        requestDispatcher.forward(req, res);
    }


}
