package com.example.tp_3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection con = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/faculte";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        if (con == null) {
            // Handle the situation where the connection is null
            // You might want to log an error or throw an exception
            // depending on your application requirements.
            // Example:
            throw new IllegalStateException("Database connection is null");
        } else {
        return con;}
    }
}
