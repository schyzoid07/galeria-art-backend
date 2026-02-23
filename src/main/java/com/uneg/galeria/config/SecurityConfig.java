package com.uneg.galeria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactivar CSRF para poder hacer POST desde el archivo .http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permitir TODAS las peticiones sin login
                );
        return http.build();
    }
}