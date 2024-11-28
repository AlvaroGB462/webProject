package com.example.webProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webProject.model.User;
import com.example.webProject.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password, Model model) {
        User user = userService.authenticateUser(email, password);

        if (user != null) {
            // Si la autenticación es exitosa, redirige a la página de bienvenida
            model.addAttribute("user", user);
            return "redirect:/welcome";
        } else {
            // Si las credenciales son incorrectas, muestra un mensaje de error
            model.addAttribute("error", "Credenciales incorrectas");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        return "welcome"; // Redirige a la página de bienvenida
    }
}

