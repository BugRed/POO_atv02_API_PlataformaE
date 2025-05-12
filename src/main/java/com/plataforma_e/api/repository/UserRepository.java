package com.plataforma_e.api.repository;

import com.plataforma_e.api.model.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    private final File file;
    private final List<User> users;

    public UserRepository(String filePath) {
        this.file = new File(filePath);
        this.users = loadUsers();
    }

    // Carrega os dados do arquivo JSON
    private List<User> loadUsers() {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            // Converte o JSON para uma lista de objetos User
            String json = jsonBuilder.toString();
            String[] userArray = json.substring(1, json.length() - 1).split("},");
            for (String userJson : userArray) {
                String[] attributes = userJson.replace("{", "").replace("}", "").split(",");
                Long id = Long.valueOf(attributes[0].split(":")[1].trim());
                String username = attributes[1].split(":")[1].trim().replace("\"", "");
                String email = attributes[2].split(":")[1].trim().replace("\"", "");
                String imgUrl = attributes[3].split(":")[1].trim().replace("\"", "");
                String statusStr = attributes[4].split(":")[1].trim().replace("\"", "");

                User user = new User(id, username, email, imgUrl);
                user.setStatus(statusStr);  // Define o status a partir do valor no arquivo
                userList.add(user);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar usuários: " + e.getMessage());
        }
        return userList;
    }

    // Salva os usuários no arquivo JSON
    public void save(User user) {
        users.add(user);
        writeToFile();
    }

    // Grava os dados no arquivo
    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write("[");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                writer.write(String.format("{\"id\":%d,\"username\":\"%s\",\"email\":\"%s\",\"imgUrl\":\"%s\",\"status\":\"%s\"}",
                        user.getId(), user.getUsername(), user.getEmail(), user.getImgUrl(), user.isActive()));
                if (i < users.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            System.err.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    // Retorna todos os usuários
    public List<User> findAll() {
        return users;
    }

    // Retorna um usuário por ID
    public User findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    // Verifica se o usuário existe
    public boolean exists(Long id) {
        return findById(id) != null;
    }

    // Deleta um usuário pelo ID
    public boolean delete(Long id) {
        boolean removed = users.removeIf(user -> user.getId().equals(id));
        if (removed) {
            writeToFile();
        }
        return removed;
    }
}
