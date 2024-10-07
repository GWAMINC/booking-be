package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.BookingDto;
import java.util.List;

public interface BookingService {
    BookingDto createBooking(BookingDto bookingDto);
    List<BookingDto> getAllBookings();
    BookingDto getBookingById(Long id);
    BookingDto updateBookingById(Long id, BookingDto bookingDto);
    void deleteBookingById(Long id);
}
