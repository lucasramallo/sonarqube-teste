package com.sonar.demo.service;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<String> users = new ArrayList<>();

    public void addUser(String username) {
        if (username != null) {
            users.add(username);
            System.out.println("Usuário adicionado: " + username); // Uso de System.out
        }
    }

    public String getUser(int index) {
        try {
            return users.get(index); // Pode causar IndexOutOfBoundsException
        } catch (Exception e) {
            e.printStackTrace(); // Má prática: logando stack trace diretamente
            return null;
        }
    }

    public void deleteAllUsers() {
        for (int i = 0; i < users.size(); i++) {
            users.remove(i); // ConcurrentModificationException
        }
    }

    public void insecureMethod(String input) {
        String query = "SELECT * FROM users WHERE name = '" + input + "'"; // SQL Injection (simulado)
        System.out.println("Executando: " + query);
    }

    // Método não utilizado
    private void unusedMethod() {
        int x = 10;
        int y = 20;
        int z = x + y;
    }
}
