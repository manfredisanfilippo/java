package com.example.gokart.bean;

import java.time.LocalDate;
import java.util.Date;

public class TournamentBean {

    private int id;
    private String name;
    private String where;
    private Integer number;
    private Float cost;
    private LocalDate date;

    public TournamentBean() {}

    public TournamentBean(int id, String name, String where, Integer number, Float cost, LocalDate date) {}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void SetId(int id) {
        this.id = id;
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

    public void checkField(String name, String where, LocalDate date, Float cost, Integer number) throws Exception{
        if (name.isEmpty() || where.isEmpty() || date == null || cost == null || number == null) {
            throw new Exception("Please fill all the fields");
        }
    }
}
