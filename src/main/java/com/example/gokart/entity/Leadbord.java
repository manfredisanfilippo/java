package com.example.gokart.entity;

public class Leadbord {
    private String driver;
    private int numberRace;
    private int totalPoint;

    public Leadbord(String driver, int numberRace, int totalPoint) {
        this.driver = driver;
        this.numberRace = numberRace;
        this.totalPoint = totalPoint;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getNumberRace() {
        return numberRace;
    }

    public void setNumberRace(int numberRace) {
        this.numberRace = numberRace;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }
}
