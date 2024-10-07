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

                    .requestMatchers("/api/place-type/create").permitAll()
                    .requestMatchers("/api/place-type/getAll").permitAll()
                    .requestMatchers("/api/place-type/getById/{id}").permitAll()
                    .requestMatchers("/api/place-type/deleteById/{id}").permitAll()
                    .requestMatchers("/api/place-type/updateById/{id}").permitAll()

                    .requestMatchers("/api/product-category/create").permitAll()
                    .requestMatchers("/api/product-category/getAll").permitAll()
                    .requestMatchers("/api/product-category/getById/{id}").permitAll()
                    .requestMatchers("/api/product-category/deleteById/{id}").permitAll()
                    .requestMatchers("/api/product-category/updateById/{id}").permitAll()

                    .requestMatchers("/api/product-category/category/create").permitAll()
                    .requestMatchers("/api/product-category/category/getAll").permitAll()
                    .requestMatchers("/api/product-category/category/getById/{id}").permitAll()
                    .requestMatchers("/api/product-category/category/deleteById/{id}").permitAll()
                    .requestMatchers("/api/product-category/category/updateById/{id}").permitAll()

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