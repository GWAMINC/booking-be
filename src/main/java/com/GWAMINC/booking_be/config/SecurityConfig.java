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
                        .requestMatchers("/api/region/getAll").permitAll()
                        .requestMatchers("/api/region/getById/{id}").permitAll()
                        .requestMatchers("/api/region/deleteById/{id}").permitAll()
                        .requestMatchers("/api/region/updateById/{id}").permitAll()

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

                        .requestMatchers("/api/property-attribute/create").permitAll()
                        .requestMatchers("/api/property-attribute/getById/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/update/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/delete/{id}").permitAll()

                        .requestMatchers("/api/property-attribute/attribute/create").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/getAllByPropertyId/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/getById/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/delete/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/update/{id}").permitAll()

                        .requestMatchers("/api/property-attribute/category/create").permitAll()
                        .requestMatchers("/api/property-attribute/category/getById/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/category/delete/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/category/update/{id}").permitAll()

                        .requestMatchers("api/property/create").permitAll()
                        .requestMatchers("/api/property/getById/{id}").permitAll()
                        .requestMatchers("/api/property/updateById/{id}").permitAll()
                        .requestMatchers("/api/property/deleteById/{id}").permitAll()
                        .requestMatchers("api/property/getAll").permitAll()

                        .requestMatchers("api/propertytype/create").permitAll()
                        .requestMatchers("/api/propertytype/getById/{id}").permitAll()
                        .requestMatchers("/api/propertytype/updateById/{id}").permitAll()
                        .requestMatchers("/api/propertytype/deleteById/{id}").permitAll()
                        .requestMatchers("api/propertytype/getAll").permitAll()
                    .anyRequest().authenticated()
            )
            .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}