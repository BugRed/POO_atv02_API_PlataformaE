package com.plataforma_e.api.dto;

import java.time.LocalDate;

public class EditalDTO {

    private String title;
    private String description;
    private LocalDate publishDate;
    private LocalDate endDate;
    private String status;



    public EditalDTO() {
    }

    public EditalDTO(String title, String description, LocalDate publishDate, LocalDate endDate, String status) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
