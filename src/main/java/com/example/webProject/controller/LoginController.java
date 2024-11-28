package com.example.webProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.webProject.service.UserService;
import com.example.webProject.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService usuarioService;

    // Página principal redirige a login si no está autenticado
    @GetMapping("/")
    public String showMainPage() {
        return "redirect:/login"; // Redirige a la página de login si no está autenticado
    }

    // Página de login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Página de login personalizada (ahora .jsp)
    }

    // Página de bienvenida (accesible solo para usuarios autenticados)
    @GetMapping("/welcome")
    public String showWelcomePage(HttpSession session, Model model) {
        User usuario = (User) session.getAttribute("usuario");
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
        }
        return "welcome"; // Página de bienvenida personalizada (ahora .jsp)
    }

    // Login de usuario
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        User usuario = usuarioService.authenticateUser(email, password); // Verifica el usuario en la base de datos
        
        if (usuario != null) {
            session.setAttribute("usuario", usuario); // Inicia sesión manualmente
            model.addAttribute("usuario", usuario); // Pasa el usuario a la vista
            return "redirect:/welcome"; // Redirige a la página de bienvenida
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login"; // Si las credenciales son incorrectas, redirige al login
        }
    }

    // Logout del usuario
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Elimina la sesión
        return "redirect:/"; // Redirige a la página de login
    }
}