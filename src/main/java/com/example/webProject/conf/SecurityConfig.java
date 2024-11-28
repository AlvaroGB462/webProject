package com.example.webProject.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Desactivar la protección CSRF (solo si es necesario)
            .authorizeRequests()
                .requestMatchers("/", "/login", "/welcome", "/static/**").permitAll()  // Permitir acceso sin autenticación a estas páginas
                .anyRequest().authenticated()  // Requerir autenticación para las demás páginas
            .and()
            .formLogin()
                .loginPage("/login")  // Usar la página de login personalizada
                .loginProcessingUrl("/login")  // URL para procesar el login
                .defaultSuccessUrl("/welcome", true)  // Redirigir a la página de bienvenida después del login
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")  // URL para procesar el logout
                .logoutSuccessUrl("/")  // Redirigir a la página de inicio después del logout
                .permitAll();
        
        return http.build();
    }
}