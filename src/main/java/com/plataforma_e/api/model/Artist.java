package com.plataforma_e.api.model;

import java.util.List;

public class Artist extends User{

    private String cpf;
    private List<Tags> tags;
    private String color;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "cpf='" + cpf + '\'' +
                ", tags=" + tags +
                ", color='" + color + '\'' +
                '}';
    }
}
