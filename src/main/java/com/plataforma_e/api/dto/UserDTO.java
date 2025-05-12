package com.plataforma_e.api.dto;

import com.plataforma_e.api.enums.UserStatus;

public class UserDTO {

    private String username;
    private String email;
    private String imgUrl;
    private UserStatus status;


    public UserDTO() {
    }

    public UserDTO(String username, String email, String imgUrl, UserStatus status) {
        this.username = username;
        this.email = email;
        this.imgUrl = imgUrl;
        this.status = status;
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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", status=" + status +
                '}';
    }
}

