package com.example.gokart.dao;

import com.example.gokart.database.DbConnection;
import com.example.gokart.database.Queries;
import com.example.gokart.entity.Tournament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TournamentDao {

    public Boolean createTournament(Tournament tournament) throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.CREATE_TOURNAMENT
                )
        ){
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournament not create");
                }
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Tournament> getAllByAdminIdTournaments(int Id) throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.FIND_ALL_TOURNAMENTS_BY_ADMIN_ID
                )

        ){
            stmt.setInt(1, Id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournaments not found");
                }
                List<Tournament> tournaments = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String where = rs.getString("where");
                    int number = rs.getInt("number");
                    float cost = rs.getFloat("cost");
                    LocalDate date = rs.getDate("date").toLocalDate();
                    String creatorName = rs.getString("creatorName");

                    Tournament item = new Tournament(id, name, where, number, cost, date, creatorName);

                    tournaments.add(item);
                }
                return tournaments;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Tournament> getAllTournaments() throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.FIND_ALL_TOURNAMENTS
                )
        ){
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournaments not found");
                }
                List<Tournament> tournaments = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String where = rs.getString("where");
                    int number = rs.getInt("number");
                    float cost = rs.getFloat("cost");
                    LocalDate date = rs.getDate("date").toLocalDate();
                    String creatorName = rs.getString("creatorName");

                    Tournament item = new Tournament(id, name, where, number, cost, date, creatorName);

                    tournaments.add(item);
                }
                return tournaments;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
