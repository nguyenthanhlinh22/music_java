package com.example.music.Models;

import com.example.music.DataBases.DataBaseConnect;
import com.example.music.Services.SongService;
import com.example.music.entity.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SongModel {
    private Connection conn;

    public SongModel() {
        this.conn = DataBaseConnect.getConnection();
    }

    public ResultSet getSongs() throws SQLException {
        String sql = "SELECT s.*, st.Statusname, c.categoryname, a.Artistsname FROM songs s JOIN categories c ON s.Category_id = c.categoryid JOIN status st ON s.status_id = st.Statusid JOIN artists a ON s.Artists_id = a.Artistsid LIMIT 0, 1000;\n";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }
    public void destroySongs(int songid) throws SQLException {
        String sql = "delete from songs where songid = ?";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        //set param
        preparedStatement.setInt(1, songid);
        preparedStatement.execute();
    }

    public void storeSong(Song song) throws SQLException {
        String sql ="INSERT INTO songs (SongName, List_id, status_id, Category_id, ReleaseDate, Artists_id) VALUES (?, ?, ?, ?, ?, ?)\n";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        preparedStatement.setString(1, song.getSongName());
        preparedStatement.setInt(2, song.getList_id());
        preparedStatement.setInt(3, song.getStatus_id());
        preparedStatement.setInt(4, song.getCategory_id());
        preparedStatement.setString(5, String.valueOf(song.getReleaseDate()));
        preparedStatement.setInt(6, song.getArtists_id());
        preparedStatement.execute();
    }



}
