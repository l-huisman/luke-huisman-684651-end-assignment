package com.example.lukehuisman684651endassignment;

public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private Role role;

    public User(int userID, String username, String password, String email, Role role) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
