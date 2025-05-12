package com.plataforma_e.api.model;

import java.util.List;

public class Proposer extends User{

    private String cnpj;

    private List<Edital> listEdital;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Edital> getListEdital() {
        return listEdital;
    }

    public void setListEdital(List<Edital> listEdital) {
        this.listEdital = listEdital;
    }

    @Override
    public String toString() {
        return "Proposer{" +
                "cnpj='" + cnpj + '\'' +
                ", listEdital=" + listEdital +
                '}';
    }
}
