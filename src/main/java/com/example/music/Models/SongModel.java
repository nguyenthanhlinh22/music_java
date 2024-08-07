package com.example.music.Models;

import com.example.music.DataBases.DataBaseConnect;
import com.example.music.Services.SongService;

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
        String sql = "select * from songs";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

}
