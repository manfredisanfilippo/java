package com.example.gokart.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/gokartdb", "Admin", "Admin");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
