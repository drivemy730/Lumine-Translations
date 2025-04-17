package com.lumine.lumine_translations.models;


import com.lumine.lumine_translations.helpers.UserRole;
import jakarta.persistence.*;

import java.security.Timestamp;


@Entity
@Table(name = "user")

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;


    @Column(name = "user_email", nullable = false, unique = true)
    private String  userEmail;

    @Column(name = "user_password", nullable = false, unique = true)
    private String  userPasswordHash;


    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, unique = true)
    private UserRole userRole;

    @Column(name = "user_created_at", nullable = false, updatable = false, insertable = false )
    private Timestamp userCreatedAt;

    @Column(name = "user_last_login" )
    private Timestamp  userLastLogin;



    // constructors

    public User() {
    }

    public User(Integer userId, String userEmail, String userPasswordHash, UserRole userRole, Timestamp userCreatedAt, Timestamp userLastLogin) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPasswordHash = userPasswordHash;
        this.userRole = userRole;
        this.userCreatedAt = userCreatedAt;
        this.userLastLogin = userLastLogin;
    }




    // getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Timestamp getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(Timestamp userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    public Timestamp getUserLastLogin() {
        return userLastLogin;
    }

    public void setUserLastLogin(Timestamp userLastLogin) {
        this.userLastLogin = userLastLogin;
    }

}
