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
                                
                                .requestMatchers("/api/booking/create").permitAll()
                                .requestMatchers("/api/booking/getAll").permitAll()
                                .requestMatchers("/api/booking/getById/{id}").permitAll()
                                .requestMatchers("/api/booking/deleteById/{id}").permitAll()
                                .requestMatchers("/api/booking/updateById/{id}").permitAll()

                                .requestMatchers("/api/booking_guests/create").permitAll()
                                .requestMatchers("/api/booking_guests/getAll").permitAll()
                                .requestMatchers("/api/booking_guests/getById/{id}").permitAll()
                                .requestMatchers("/api/booking_guests/deleteById/{id}").permitAll()
                                .requestMatchers("/api/booking_guests/updateById/{id}").permitAll()

                                .requestMatchers("/api/guesttype/create").permitAll()
                                .requestMatchers("/api/guesttype/getAll").permitAll()
                                .requestMatchers("/api/guesttype/getById/{id}").permitAll()
                                .requestMatchers("/api/guesttype/deleteById/{id}").permitAll()
                                .requestMatchers("/api/guesttype/updateById/{id}").permitAll()

                                .requestMatchers("/api/location/create").permitAll()
                                .requestMatchers("/api/location/getAll").permitAll()
                                .requestMatchers("/api/location/getById/{id}").permitAll()
                                .requestMatchers("/api/location/deleteById/{id}").permitAll()
                                .requestMatchers("/api/location/updateById/{id}").permitAll()

                                .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
