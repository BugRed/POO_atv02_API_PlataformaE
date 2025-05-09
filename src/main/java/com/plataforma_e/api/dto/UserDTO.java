package com.plataforma_e.api.dto;

public class UserDTO {

        private String username;
        private String email;

        public UserDTO(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public UserDTO() {
        }

        public String getUsername() { return username; }
        public String getEmail() { return email; }

        public void setUsername(String username) { this.username = username; }
        public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

