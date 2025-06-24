package com.example.mindboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    //Metodo que irá criptografar a senha.
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Libera o acesso a todos os endpoints.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
     http
             .csrf(csrf -> csrf.disable())
             .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
             )
             .httpBasic(Customizer.withDefaults());
        return http.build();
    }

}