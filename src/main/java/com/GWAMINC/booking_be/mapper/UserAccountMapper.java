package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.UserAccountDto;
import com.GWAMINC.booking_be.entity.UserAccount;

public class UserAccountMapper {
    public static UserAccountDto mapToDto(UserAccount userAccount) {
        return new UserAccountDto(
                userAccount.getId(),
                userAccount.getFirstName(),
                userAccount.getLastName(),
                userAccount.getEmailAddress(),
                userAccount.getPassword());
    }

    public static UserAccount mapToEntity(UserAccountDto userAccountDto) {
        return new UserAccount(
                userAccountDto.getId(),
                userAccountDto.getFirstName(),
                userAccountDto.getLastName(),
                userAccountDto.getEmailAddress(),
                userAccountDto.getPassword());
    }
}
