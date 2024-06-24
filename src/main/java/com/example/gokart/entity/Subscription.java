package com.example.gokart.entity;

public class Subscription {

    private int vote;
    private String driver;
    public String tournament;
    private int idDriver;
    private int idTournament;

    public Subscription(int idDriver, int idTournament, int vote, String driver, String tournament) {
        this.vote = vote;
        this.idDriver = idDriver;
        this.idTournament = idTournament;
        this.driver = driver;
        this.tournament = tournament;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }
}
