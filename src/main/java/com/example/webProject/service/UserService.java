package com.example.webProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.webProject.model.User;

@Service
public class UserService {

    private static final String API_URL = "http://localhost:8081/api/user"; // URL de la API

    private final RestTemplate restTemplate;

    // Inyección de dependencias del RestTemplate
    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User authenticateUser(String email, String password) {
        String url = API_URL + "/login?email=" + email;
        User user = restTemplate.getForObject(url, User.class);

        if (user != null && BCrypt.checkpw(password, user.getPasswordHash())) {
            return user; // Retorna el usuario autenticado si las credenciales son correctas
        }
        return null; // Si no se encuentra el usuario o las credenciales son incorrectas
    }
}
