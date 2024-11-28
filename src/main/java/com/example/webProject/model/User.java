package com.example.webProject.model;

public class User {
    private String email;
    private String passwordHash;
    private boolean admin;

    public User(String email, String passwordHash, boolean admin) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isAdmin() {
        return admin;
    }
}
