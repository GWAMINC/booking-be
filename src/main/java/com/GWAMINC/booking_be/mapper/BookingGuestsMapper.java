package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.BookingGuestsDto;
import com.GWAMINC.booking_be.entity.BookingGuests;

public class BookingGuestsMapper {
    public static BookingGuestsDto mapToDto(BookingGuests bookingGuests) {
        return new BookingGuestsDto(
                bookingGuests.getId(),
                bookingGuests.getBooking().getId(),
                bookingGuests.getGuestType().getId(),
                bookingGuests.getNumGuests()
        );
    }

    public static BookingGuests mapToEntity(BookingGuestsDto bookingGuestsDto) {
        BookingGuests bookingGuests = new BookingGuests();
        bookingGuests.setId(bookingGuestsDto.getId());
        bookingGuests.setNumGuests(bookingGuestsDto.getNumGuests());
        return bookingGuests;
    }
}
