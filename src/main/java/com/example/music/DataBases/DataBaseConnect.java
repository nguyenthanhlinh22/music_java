package com.example.music.DataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnect {
    private static  final String  Url = "jdbc:mysql://localhost:3306/music?useSSL=false" ;
    private static  final String  User = "root" ;
    private static  final String  Pass = "thanhlinh22" ;

    public DataBaseConnect() {};

    public static Connection getConnection() {
        Connection conn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(Url,User, Pass);
                System.out.println("Connected to the database successfully");
            } catch (SQLException | ClassNotFoundException  e) {
                throw new RuntimeException(e);
            }
            return conn;
    }
}
