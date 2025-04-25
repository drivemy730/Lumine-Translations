package com.lumine.lumine_translations.models;


import com.lumine.lumine_translations.helpers.UserRole;
import jakarta.persistence.*;

import java.security.Timestamp;


@Entity
@Table(name = "users")

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    @Column(name = "user_email", nullable = false, unique = true)
    private String  email;

    @Column(name = "user_password", nullable = false, unique = true)
    private String  passwordHash;


    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Column(name = "user_created_at", nullable = false, updatable = false, insertable = false )
    private Timestamp createdAt;

    @Column(name = "user_last_login" )
    private Timestamp  lastLogin;



    // Constructors

    public User() {
    }

    public User(Integer userId, String email, String passwordHash, UserRole userRole, Timestamp lastLogin, Timestamp createdAt)
    {
        this.userId = userId;
        this.email = email;
        this.passwordHash = passwordHash;
        this.userRole = userRole;
        this.lastLogin = lastLogin;
        this.createdAt = createdAt;
    }



    // Getters and setters

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }
}