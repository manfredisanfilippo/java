package com.example.gokart.dao;

import com.example.gokart.bean.LoginBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.database.DbConnection;
import com.example.gokart.database.Queries;
import com.example.gokart.entity.Leadbord;
import com.example.gokart.entity.Subscription;
import com.example.gokart.entity.Tournament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDao {
    public void subscription(LoginBean login, TournamentBean tournament) {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.DO_SUBSCRIPTION
                )
        ){
            stmt.setInt(1, login.getId());
            stmt.setString(2, login.getUsername());
            stmt.setInt(3, tournament.getId());
            stmt.setString(4, tournament.getName());
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournament not create");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Tournament> getAllSubscriptions(int Id) {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.GET_ALL_MY_SUBSCRIPTIONS
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Leadbord> GetLeadboard() {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.GET_LEADBOARD
                )
        ){
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournaments not found");
                }
                List<Leadbord> leadbords = new ArrayList<>();
                while (rs.next()) {
                    String driver = rs.getString("driver");
                    int numberRace = rs.getInt("numberRace");
                    int totalPoint = rs.getInt("totalPoint");

                    Leadbord item = new Leadbord(driver, numberRace, totalPoint);

                    leadbords.add(item);
                }
                return leadbords;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Subscription> GetTournamentSubscription(TournamentBean tournamentBean) {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.GET_TOURNAMENT_SUBSCRIPTIO
                )
        ){
            stmt.setInt(1, tournamentBean.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournaments not found");
                }
                List<Subscription> subscriptions = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("driverId");
                    int tournamentId = rs.getInt("tournamentId");
                    String driver = rs.getString("driver");
                    int vote = rs.getInt("vote");
                    String tournament = rs.getString("tournament");

                    Subscription item = new Subscription(id, tournamentId, vote, driver, tournament);

                    subscriptions.add(item);
                }
                return subscriptions;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean UpdateSubscription(int id, int tournamentId) {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.UPDATE_VOTE
                )
        ){
            stmt.setInt(1, id);
            stmt.setInt(2, tournamentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Vote not update");
                }
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
