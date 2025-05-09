package com.plataforma_e.api.repository;

import com.bugred.API.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Repositório responsável por armazenar e recuperar os Users
 * de cada jogador (Player), agrupados por id.
 */
public class UserRepository {

    private final Map<UUID, User> userStorage = new HashMap<>();
    private final String filePath;
    private final Gson gson = new Gson();

    public UserRepository(String filePath) {
        this.filePath = filePath;
        loadFromFile();
    }

    public List<User> findAll() {
        return new ArrayList<>(userStorage.values());
    }

    public User findById(UUID userId) {
        return userStorage.get(userId);
    }

    public void save(User user) {
        userStorage.put(user.getId(), user);
        saveToFile();
    }

    public boolean delete(UUID userId) {
        if (userStorage.remove(userId) != null) {
            saveToFile();
            return true;
        }
        return false;
    }

    public boolean exists(UUID userId) {
        return userStorage.containsKey(userId);
    }

    private void loadFromFile() {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("{}");
                }
            }

            try (FileReader reader = new FileReader(file)) {
                Type type = new TypeToken<Map<UUID, User>>() {}.getType();
                Map<UUID, User> data = gson.fromJson(reader, type);
                if (data != null) {
                    userStorage.clear();
                    userStorage.putAll(data);
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Erro ao carregar usuários do arquivo: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(userStorage, writer);
        } catch (IOException e) {
            System.err.println("❌ Erro ao salvar usuários no arquivo: " + e.getMessage());
        }
    }
}

