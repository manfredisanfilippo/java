package com.example.gokart.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
    private String username;
    private String password;
    private String role;
    private String checkPassword;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int role) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void SetCheckPassword(String checkPassword) { this.checkPassword = checkPassword; }

    public String getCheckPassword() {return checkPassword; }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkField(String username, String password) throws Exception{
        if (username.isEmpty() || password.isEmpty()) {
            throw new Exception("Please fill all the fields");
        }
    }

    public void checkIfPassIsEqual(String password, String checkPassword) throws Exception {
        if (!password.equals(checkPassword)) {
            throw new Exception("password is not Equal");
        }
    }
}