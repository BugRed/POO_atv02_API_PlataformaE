package com.plataforma_e.api.db;

import com.google.gson.Gson;
import com.plataforma_e.api.model.User;
import com.plataforma_e.api.service.UserService;

import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MockDataLoader {

    private static final Gson gson = new Gson();

    /**
     * Lê o arquivo mockData.json e adiciona os usuários ao serviço correspondente.
     */
    public static void loadMockData(UserService userService) {
        try (InputStream inputStream = MockDataLoader.class.getClassLoader().getResourceAsStream("mock/users.json");
             InputStreamReader reader = inputStream != null
                     ? new InputStreamReader(inputStream, StandardCharsets.UTF_8)
                     : null) {

            if (reader == null) {
                System.err.println("mockData não encontrado. Verifique se está em src/main/resources/mock.");
                return;
            }

            Type userListType = new TypeToken<List<User>>() {}.getType();
            List<User> users = gson.fromJson(reader, userListType);

            if (users == null || users.isEmpty()) {
                System.err.println("mockData está vazio ou mal formatado.");
                return;
            }

            // ✅ Adiciona os usuários ao repositório via serviço
            users.forEach(user -> userService.getRepository().save(user));

            System.out.println("Mock data carregado com sucesso.");

        } catch (Exception e) {
            System.err.println("Erro ao carregar mock data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
