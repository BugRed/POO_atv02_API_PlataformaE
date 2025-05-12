package com.plataforma_e.api.application;

import com.plataforma_e.api.controller.UserController;
import com.plataforma_e.api.dto.UserDTO;
import com.plataforma_e.api.model.User;
import java.util.Scanner;


/**
 * Classe responsavel por interagir com o usuário.
 * */
public class ConsoleApp {

    private static final UserController controller = new UserController();


    public static void showMenu() {
        System.out.println("\n=== MENU USUÁRIOS ===");
        System.out.println("1 - Listar todos");
        System.out.println("2 - Ver por ID");
        System.out.println("3 - Criar novo");
        System.out.println("4 - Atualizar");
        System.out.println("5 - Remover");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    public static void listUsers() {
        var users = controller.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            users.forEach(System.out::println);
        }
    }

    public static void listUsersWithId() {
        var users = controller.getAllUsersWithId();
        if (users.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            users.forEach(User::toString);
        }
    }

    public static void viewUser(Scanner scanner) {
        System.out.print("ID: ");
        long id = Long.parseLong(scanner.nextLine());
        var user = controller.getUserById(id);
        // if dentro de uma função
        user.ifPresentOrElse(
                u -> System.out.println("Usuário: " + u.getUsername() + " - " + u.getEmail()),
                () -> System.out.println("Usuário não encontrado.")
        );
    }

    public static void createUser(Scanner scanner) {
        User user = new User();
        System.out.print("Username: ");
        user.setUsername(scanner.nextLine());
        System.out.print("Email: ");
        user.setEmail(scanner.nextLine());
        System.out.print("Img URL: ");
        user.setImgUrl(scanner.nextLine());
        System.out.print("Status (ACTIVE/INACTIVE): ");
        user.setStatus(scanner.nextLine().toUpperCase());

        // gerando um id
        user.setId(1L + controller.getAllUsersWithId().size());

        controller.createUser(user);
        System.out.println("Usuário criado com sucesso.");
    }

    public static void updateUser(Scanner scanner) {
        System.out.print("ID do usuário: ");
        long id = Long.parseLong(scanner.nextLine());
        if (controller.getUserById(id).isEmpty()) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        User user = new User();
        user.setId(id); // obrigatório
        System.out.print("Novo username: ");
        user.setUsername(scanner.nextLine());
        System.out.print("Novo email: ");
        user.setEmail(scanner.nextLine());
        System.out.print("Nova img URL: ");
        user.setImgUrl(scanner.nextLine());
        System.out.print("Novo status: ");
        user.setStatus(scanner.nextLine().toUpperCase());

        boolean success = controller.updateUser(id, user);
        System.out.println(success ? "Atualizado!" : "Erro ao atualizar.");
    }

    public static void deleteUser(Scanner scanner) {
        System.out.print("ID do usuário a remover: ");
        long id = Long.parseLong(scanner.nextLine());
        boolean deleted = controller.deleteUser(id);
        System.out.println(deleted ? "Removido com sucesso." : "Usuário não encontrado.");
    }
}

