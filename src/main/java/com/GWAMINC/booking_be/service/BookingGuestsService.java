package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.BookingGuestsDto;
import java.util.List;

public interface BookingGuestsService {
    BookingGuestsDto createBookingGuest(BookingGuestsDto bookingGuestsDto);
    List<BookingGuestsDto> getAllBookingGuests();
    BookingGuestsDto getBookingGuestById(Long id);
    BookingGuestsDto updateBookingGuestById(Long id, BookingGuestsDto bookingGuestsDto);
    void deleteBookingGuestById(Long id);
}