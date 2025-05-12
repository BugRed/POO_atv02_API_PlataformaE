package com.plataforma_e.api.model;

public class Tags {

    private String tagName;
    private String tagDescription;

    public Tags() {
    }

    public Tags(String tagName, String tagDescription) {
        this.tagName = tagName;
        this.tagDescription = tagDescription;
    }
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {}

    public String getTagDescription() {
        return tagDescription;
    }
    public void setTagDescription(String tagDescription) {}

    @Override
    public String toString() {
        return "Tags{" +
                "tagName='" + tagName + '\'' +
                ", tagDescription='" + tagDescription + '\'' +
                '}';
    }
}
