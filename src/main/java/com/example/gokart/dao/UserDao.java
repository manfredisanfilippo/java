package com.example.gokart.dao;

import com.example.gokart.database.DbConnection;
import com.example.gokart.database.Queries;
import com.example.gokart.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User findUser(String username, String password) throws SQLException, Exception {

        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.FIND_USER
                )
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("User not found");
                }
                rs.first();
                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String role = rs.getString("role");

                return new User(id, username1, role);
            }
        }
    }

    public Boolean createUser(String username, String password, String role) throws SQLException, Exception {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.CREATE_USER
                )
        ){
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("User not create");
                }
                return true;
            }
        }
    }
}
