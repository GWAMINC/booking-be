package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.BookingStatusDto;

import java.util.List;

public interface BookingStatusService {
    BookingStatusDto createBookingStatus(BookingStatusDto bookingStatusDto);
    List<BookingStatusDto> getAllBookingStatuses();
    BookingStatusDto getBookingStatusById(Long id);
    BookingStatusDto updateBookingStatusById(Long id, BookingStatusDto bookingStatusDto);
    void deleteBookingStatusById(Long id);
}
