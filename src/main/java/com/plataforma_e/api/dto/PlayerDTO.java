package com.plataforma_e.api.dto;

import java.util.ArrayList;
import java.util.List;

public class PlayerDTO extends UserDTO {

    private String playerName;

    private List<CharacterRequestDTO> listCharacter;

    public PlayerDTO() {
        this.listCharacter = new ArrayList<>();
    }

    public PlayerDTO(String playerName) {
        this.playerName = playerName;
        this.listCharacter = new ArrayList<>();
    }

    public PlayerDTO(String playerName, List<CharacterRequestDTO> characterRequestDTOS) {
        this.playerName = playerName;
        this.listCharacter = characterRequestDTOS;
    }

    // Getter e Setter para o nome do jogador
    public String getPlayerName() {
        return playerName;
    }

    public PlayerDTO setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    // Getter e Setter antigo com nome errado (mantido por compatibilidade)
    public List<CharacterRequestDTO> getListPerson() {
        return listCharacter;
    }

    public PlayerDTO setListPerson(List<CharacterRequestDTO> listCharacter) {
        this.listCharacter = listCharacter;
        return this;
    }

    // Getter correto para lista de personagens
    public List<CharacterRequestDTO> getListCharacter() {
        return listCharacter;
    }

    // Setter correto para lista de personagens
    public PlayerDTO setListCharacter(List<CharacterRequestDTO> listCharacter) {
        this.listCharacter = listCharacter;
        return this;
    }

    // Representação em string do DTO
    @Override
    public String toString() {
        return "PlayerDTO{" +
                ", playerName='" + playerName + '\'' +
                ", listCharacter=" + listCharacter +
                '}';
    }
}
