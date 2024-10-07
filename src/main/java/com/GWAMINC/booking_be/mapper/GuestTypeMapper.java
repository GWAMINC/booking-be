package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.GuestTypeDto;
import com.GWAMINC.booking_be.entity.GuestType;

public class GuestTypeMapper {
    public static GuestTypeDto mapToDto(GuestType guestType) {
        return new GuestTypeDto(
                guestType.getId(),
                guestType.getTypeName()
        );
    }

    public static GuestType mapToEntity(GuestTypeDto guestTypeDto) {
        GuestType guestType = new GuestType();
        guestType.setId(guestTypeDto.getId());
        guestType.setTypeName(guestTypeDto.getTypeName());
        return guestType;
    }
}
