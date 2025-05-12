package com.plataforma_e.api.dto;


import java.util.List;

public class ProposerDTO {

    private String cnpj;
    private List<EditalDTO> listEdital;

    public ProposerDTO() {
    }

    public ProposerDTO(String cnpj, List<EditalDTO> listEdital) {
        this.cnpj = cnpj;
        this.listEdital = listEdital;
    }

    public List<EditalDTO> getListEdital() {
        return listEdital;
    }

    public void setListEdital(List<EditalDTO> listEdital) {
        this.listEdital = listEdital;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
