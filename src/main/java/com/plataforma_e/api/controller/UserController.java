package com.plataforma_e.api.controller;

import com.google.gson.Gson;
import com.plataforma_e.api.dto.DTOFactory;
import com.plataforma_e.api.dto.UserDTO;
import com.plataforma_e.api.model.User;
import com.plataforma_e.api.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserController {

    private final UserService service;
    private final Gson gson = new Gson();

    public UserController() {
        service = UserService.getInstance();  // Usa o serviço que já está configurado com repositório de arquivo
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> dtos =  service.findAll().stream()
                .map(DTOFactory::fromUser)  // Usa metodo específico em vez de cast
                .collect(Collectors.toList());  // Coleta em uma lista imutável

        return dtos;
    }

    public List<User> getAllUsersWithId() {
        return service.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(service.findById(id));
    }

    public UserDTO createUser(User user) {
        User created = service.create(user);
        return (UserDTO) DTOFactory.toDTO(created);  // Retorna o DTO criado para possível exibição
    }

    public boolean updateUser(Long id, User user) {
        User updated = service.update(id, user);
        return updated != null;
    }

    public boolean deleteUser(Long id) {
        return service.delete(id);
    }
}
