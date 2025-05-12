package com.plataforma_e.api.enums;

public enum UserStatus {
    ACTIVE("Usuário Ativo"),
    INACTIVE("Usuário Inativo");

    private final String descricao;

    UserStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
