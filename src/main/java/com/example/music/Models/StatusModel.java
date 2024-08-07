package com.example.music.Models;

import com.example.music.DataBases.DataBaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusModel {
    private Connection conn;

    public StatusModel() {
        this.conn = DataBaseConnect.getConnection();
    }

    public ResultSet getAllStatus() throws SQLException {
        String sql = "select * from status";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }
}
