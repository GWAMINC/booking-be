package com.GWAMINC.booking_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/api/region/create").permitAll()

                    .requestMatchers("/api/placetype/create").permitAll()
                    .requestMatchers("/api/placetype/getAll").permitAll()
                    .requestMatchers("/api/placetype/getById/{id}").permitAll()
                    .requestMatchers("/api/placetype/deleteById/{id}").permitAll()
                    .requestMatchers("/api/placetype/updateById/{id}").permitAll()

                    .requestMatchers("/api/country/create").permitAll()
                    .requestMatchers("/api/country/getAll").permitAll()
                    .requestMatchers("/api/country/getById/{id}").permitAll()
                    .requestMatchers("/api/country/deleteById/{id}").permitAll()
                    .requestMatchers("/api/country/updateById/{id}").permitAll()

                    .requestMatchers("/api/attribute/create").permitAll()
                    .requestMatchers("/api/attribute/getById/{id}").permitAll()
                    .requestMatchers("/api/attribute/delete/{id}").permitAll()
                    .requestMatchers("/api/attribute/update/{id}").permitAll()

                    .requestMatchers("/api/attributeCategory/create").permitAll()
                    .requestMatchers("/api/attributeCategory/getById/{id}").permitAll()
                    .requestMatchers("/api/attributeCategory/delete/{id}").permitAll()
                    .requestMatchers("/api/attributeCategory/update/{id}").permitAll()

                    .anyRequest().authenticated()
            )
            .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}