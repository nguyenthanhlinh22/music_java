package com.example.music.Models;

import com.example.music.DataBases.DataBaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistModel {
    private Connection conn;

    public ArtistModel() {
        this.conn = DataBaseConnect.getConnection();
    }

    public ResultSet getAllArtists() throws SQLException {
        String sql = "select * from artists";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    public void destroyArtist(int Artistsid) throws SQLException {
        String sql = "delete from artists where Artistsid = ?";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        preparedStatement.setInt(1, Artistsid);
        preparedStatement.execute();
    }



}
