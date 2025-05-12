package com.plataforma_e.api.model;

import com.plataforma_e.api.enums.UserStatus;

public class User {

    // Mudando id para
    private Long id;
    private String username;
    private String email;
    private String imgUrl;
    private UserStatus status;

    // Construtor com argumentos
    public User(Long id, String username, String email, String imgUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.imgUrl = imgUrl;
        this.status = UserStatus.ACTIVE;
    }

    public User() {

    }

    public User(String username, String email, String imgUrl, UserStatus status) {
        this.username = username;
        this.email = email;
        this.imgUrl = imgUrl;
        this.status = status;
    }

    public UserStatus isActive() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status.equals("ACTIVE") ? UserStatus.ACTIVE : UserStatus.INACTIVE;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", status=" + status +
                '}';
    }
}
