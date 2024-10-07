package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.GuestTypeDto;

import java.util.List;

public interface GuestTypeService {
    GuestTypeDto createGuestType(GuestTypeDto guestTypeDto);
    List<GuestTypeDto> getAllGuestTypes();
    GuestTypeDto getGuestTypeById(Long id);
    GuestTypeDto updateGuestTypeById(Long id, GuestTypeDto guestTypeDto);
    void deleteGuestTypeById(Long id);
}
