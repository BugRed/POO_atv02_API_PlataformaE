package com.plataforma_e.api;

import com.plataforma_e.api.application.ConsoleApp;
import com.plataforma_e.api.service.UserService;

import java.util.Scanner;

/**
 * Classe que serve para startar a API
 *
 * */
public class StartAPI {

    public static void Start() {
        try {
            final Scanner sc = new Scanner(System.in);

            int option;
            do {
                ConsoleApp.showMenu();
                option = Integer.parseInt(sc.nextLine());
                switch (option) {
                    case 1 -> ConsoleApp.listUsers();
                    case 2 -> ConsoleApp.viewUser(sc);
                    case 3 -> ConsoleApp.createUser(sc);
                    case 4 -> ConsoleApp.updateUser(sc);
                    case 5 -> ConsoleApp.deleteUser(sc);
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } while (option != 0);

            sc.close();
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
