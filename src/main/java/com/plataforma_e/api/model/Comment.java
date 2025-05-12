package com.plataforma_e.api.model;

import java.time.LocalDateTime;

public class Comment {
    private Long id;

    private String authorName;
    private String content;
    private LocalDateTime createdAt;
    private boolean approved;
    private String status;

    private User user;
    // Link com o edital que faz parte
    private Edital edital;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Edital getEdital() {
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", approved=" + approved +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", edital=" + edital +
                '}';
    }
}
