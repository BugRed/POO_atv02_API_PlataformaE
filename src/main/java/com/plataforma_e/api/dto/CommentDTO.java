package com.plataforma_e.api.dto;

import java.time.LocalDateTime;

public class CommentDTO {

    private String authorName;
    private String content;
    private LocalDateTime createdAt;
    private boolean approved;
    private String status;

    public CommentDTO() {
    }

    public CommentDTO(String authorName, String content,
                      LocalDateTime createdAt,
                      boolean approved, String status) {
        this.authorName = authorName;
        this.content = content;
        this.createdAt = createdAt;
        this.approved = approved;
        this.status = status;
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
}
