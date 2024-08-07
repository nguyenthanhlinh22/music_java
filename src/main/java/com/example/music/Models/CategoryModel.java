package com.example.music.Models;

import com.example.music.DataBases.DataBaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryModel {
    private Connection conn;

    public CategoryModel() {
        this.conn = DataBaseConnect.getConnection();
    }

    public ResultSet getAllCategory() throws SQLException {
        String sql = "select * from categories";
        PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }
}
