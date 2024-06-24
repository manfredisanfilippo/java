package com.example.gokart.entity;

import java.time.LocalDate;

public class Tournament {
    private String name;
    private String where;
    private Integer number;
    private Float cost;
    private LocalDate date;
    private int id;
    private String creatorName;

    public Tournament(String name, String where, Integer number, Float cost, LocalDate date, String creatorName) {
        this.name = name;
        this.where = where;
        this.number = number;
        this.cost = cost;
        this.date = date;
        this.creatorName = creatorName;
    }

    public Tournament(int id, String name, String where, Integer number, Float cost, LocalDate date, String creatorName) {
        this.id = id;
        this.name = name;
        this.where = where;
        this.number = number;
        this.cost = cost;
        this.date = date;
        this.creatorName = creatorName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }


}
