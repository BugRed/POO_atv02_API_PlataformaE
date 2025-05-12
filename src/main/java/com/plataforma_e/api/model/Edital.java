package com.plataforma_e.api.model;

import java.time.LocalDate;
import java.util.List;

public class Edital {

    private Long id;

    private String title;
    private String description;
    private LocalDate publishDate;
    private LocalDate endDate;
    private String status;
    private String inscriptionLink;
    private String completeEditalLink;
    private String imgCoverUrl;

    private List<Tags> listTags;

    private List<Comment> listComment;


    public Long getId() {
        return id;
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

    public String getInscriptionLink() {
        return inscriptionLink;
    }

    public void setInscriptionLink(String inscriptionLink) {
        this.inscriptionLink = inscriptionLink;
    }

    public String getCompleteEditalLink() {
        return completeEditalLink;
    }

    public void setCompleteEditalLink(String completeEditalLink) {
        this.completeEditalLink = completeEditalLink;
    }

    public String getImgCoverUrl() {
        return imgCoverUrl;
    }

    public void setImgCoverUrl(String imgCoverUrl) {
        this.imgCoverUrl = imgCoverUrl;
    }

    public List<Tags> getListTags() {
        return listTags;
    }

    public void setListTags(List<Tags> listTags) {
        this.listTags = listTags;
    }

    public List<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(List<Comment> listComment) {
        this.listComment = listComment;
    }

    @Override
    public String toString() {
        return "Edital{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publishDate=" + publishDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                ", inscriptionLink='" + inscriptionLink + '\'' +
                ", completeEditalLink='" + completeEditalLink + '\'' +
                ", imgCoverUrl='" + imgCoverUrl + '\'' +
                ", listTags=" + listTags +
                ", listComment=" + listComment +
                '}';
    }
}
