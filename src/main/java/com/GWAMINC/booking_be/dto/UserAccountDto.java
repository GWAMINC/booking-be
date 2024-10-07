package com.GWAMINC.booking_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
}
