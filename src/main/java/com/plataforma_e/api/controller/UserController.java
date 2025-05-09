package com.plataforma_e.api.controller;

import com.bugred.API.dto.DTOFactory;
import com.bugred.API.dto.request.UserRequestDTO;
import com.bugred.API.model.Player;
import com.bugred.API.model.User;
import com.bugred.API.service.UserService;
import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserController {

    private final UserService service = UserService.getInstance();
    private final Gson gson = new Gson();

    public String getAllUsers() {
        List<UserRequestDTO> dtos = service.findAll().stream()
                .map(p -> (UserRequestDTO) DTOFactory.toDTO(p))
                .collect(Collectors.toList());
        return gson.toJson(dtos);
    }

    public String getUserById(UUID id) {
        User user = service.findById(id);
        if (user == null) {
            return "{\"error\": \"Usuário não encontrado\"}";
        }
        return gson.toJson(DTOFactory.toDTO(user));
    }

    public String createUser(InputStreamReader reader) {
        UserRequestDTO dto = gson.fromJson(reader, UserRequestDTO.class);
        User user = DTOFactory.fromDTO(dto, Player.class);
        User created = service.create(user);
        return gson.toJson(DTOFactory.toDTO(created));
    }

    public String updateUser(UUID id, InputStreamReader reader) {
        UserRequestDTO dto = gson.fromJson(reader, UserRequestDTO.class);
        User updatedEntity = DTOFactory.fromDTO(dto, Player.class);
        User updated = service.update(id, updatedEntity);
        if (updated == null) {
            return "{\"error\": \"Usuário não encontrado para atualização\"}";
        }
        return gson.toJson(DTOFactory.toDTO(updated));
    }

    public String deleteUser(UUID id) {
        boolean deleted = service.delete(id);
        return deleted ?
                "{\"message\": \"Usuário " + id + " deletado com sucesso\"}" :
                "{\"error\": \"Usuário não encontrado\"}";
    }
}