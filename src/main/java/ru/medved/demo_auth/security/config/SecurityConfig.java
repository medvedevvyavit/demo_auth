package ru.medved.demo_auth.security.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}