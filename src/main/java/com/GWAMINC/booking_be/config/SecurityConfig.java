package com.GWAMINC.booking_be.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
                        .requestMatchers("/api/country/getByRegionId/{regionId}").permitAll()
                        .requestMatchers("/api/country/deleteById/{id}").permitAll()
                        .requestMatchers("/api/country/updateById/{id}").permitAll()

                        .requestMatchers("/api/location/create").permitAll()
                        .requestMatchers("/api/location/getAll").permitAll()
                        .requestMatchers("/api/location/getById/{id}").permitAll()
                        .requestMatchers("/api/location/getByCountryId/{countryId}").permitAll()
                        .requestMatchers("/api/location/deleteById/{id}").permitAll()
                        .requestMatchers("/api/location/updateById/{id}").permitAll()

                        .requestMatchers("/api/property-attribute/create").permitAll()
                        .requestMatchers("/api/property-attribute/getById/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/update/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/delete/{id}").permitAll()

                        .requestMatchers("/api/property-attribute/attribute/create").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/getAllByPropertyId/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/getById/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/getAll").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/delete/{id}").permitAll()
                        .requestMatchers("/api/property-attribute/attribute/update/{id}").permitAll()

                        .requestMatchers("/api/property-attribute/category/create").permitAll()
                        .requestMatchers("/api/property-attribute/category/getAll").permitAll()
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

                        .requestMatchers("/api/user-review", "/api/user-review/**").permitAll()
                        .anyRequest().authenticated()
            )
            .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}

