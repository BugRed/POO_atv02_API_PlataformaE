package com.plataforma_e.api.service;

import com.bugred.API.model.User;
import com.bugred.API.repository.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserService {


    private static UserService instance;

    private final UserRepository repository = new UserRepository("src/main/resources/data/users.json");


    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    /** Retorna todos os jogadores */
    public List<User> findAll() {
        return repository.findAll();
    }

    /** Busca jogador por ID */
    public User findById(UUID id) {
        return repository.findById(id);
    }

    /** Cria novo jogador, gerando ID automaticamente */
    public User create(User user) {
        UUID id = UUID.randomUUID();
        user.setId(id);
        repository.save(user);
        return user;
    }

    /** Atualiza um jogador existente */
    public User update(UUID id, User updatedUser) {
        if (!repository.exists(id)) return null;
        updatedUser.setId(id);
        repository.save(updatedUser);
        return updatedUser;
    }

    /** Remove jogador pelo ID */
    public boolean delete(UUID id) {
        return repository.delete(id);
    }

    /**
     * Adiciona um jogador manualmente — usado para carregar dados mockados.
     * Se o jogador já tiver um ID definido, o ID é preservado.
     */
    public void addUser(User user) {
        if (user.getId() == null) {
            UUID id = UUID.randomUUID();
            user.setId(id);
        }
        repository.save(user);
    }
}

