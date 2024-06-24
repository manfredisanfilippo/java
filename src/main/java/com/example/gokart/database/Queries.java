package com.example.gokart.database;

public class Queries {
    public static final String FIND_USER =
            "SELECT * FROM user WHERE username = ? AND password = ?";

    public static final String CREATE_USER =
            "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";

    public static final String CREATE_TOURNAMENT =
            "INSERT INTO user (name, where, number, cost, date, creatorName) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String FIND_ALL_TOURNAMENTS_BY_ADMIN_ID =
            "SELECT * FROM tournament WHERE adminId = ?";

    public static final String FIND_ALL_TOURNAMENTS =
            "SELECT * FROM tournament";

    public static String DO_SUBSCRIPTION =
            "INSERT INTO subscription (userId, driver ,TournamentId, tournament) VALUES (?, ?, ?, ?)";

    public static String GET_ALL_MY_SUBSCRIPTIONS =
            "SELECT * FROM tournament INNER JOIN subscription ON tournament.TournamentId = subscription.TournamentId and subscription.userId = ?";

    public static String GET_LEADBOARD =
            "SELECT * FROM leadboard";

    public static String GET_TOURNAMENT_SUBSCRIPTIO =
            "SELECT * FROM subscription WHERE TournamentId = ?";

    public static String UPDATE_VOTE =
            "UPDATE subscription SET vote = ? WHERE userId = ? AND TournamentId = ?";
}
