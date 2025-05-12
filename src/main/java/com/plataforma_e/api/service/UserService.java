package com.plataforma_e.api.service;

import com.plataforma_e.api.model.User;
import com.plataforma_e.api.repository.UserRepository;

import java.util.List;

public class UserService {

    private static UserService instance;
    private final UserRepository repository;

    // O repositório agora é instanciado com o caminho do arquivo JSON
    private UserService() {
        this.repository = new UserRepository("src/main/resources/mock/users.json");
    }

    /** Retorna a instância de service */
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    /** Retorna a instância do repository */
    public UserRepository getRepository() {
        return repository;
    }

    /** Retorna todos os usuários */
    public List<User> findAll() {
        return repository.findAll();
    }

    /** Busca usuário por ID */
    public User findById(Long id) {
        return repository.findById(id);
    }

    /** Cria novo usuário, gerando ID automaticamente */
    public User create(User user) {
        Long id = generateUniqueId();
        user.setId(id);
        repository.save(user);
        return user;
    }

    /** Atualiza um usuário existente */
    public User update(Long id, User updatedUser) {
        if (!repository.exists(id)) return null;
        updatedUser.setId(id);
        repository.save(updatedUser);
        return updatedUser;
    }

    /** Remove usuário pelo ID */
    public boolean delete(Long id) {
        return repository.delete(id);
    }

    /** Gera um ID único baseado no maior ID já existente */
    private Long generateUniqueId() {
        List<User> users = repository.findAll();
        return users.stream()
                .mapToLong(User::getId)
                .max()
                .orElse(0L) + 1; // Garante um ID único e sequencial
    }
}
