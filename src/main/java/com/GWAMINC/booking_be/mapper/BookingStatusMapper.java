package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.BookingStatusDto;
import com.GWAMINC.booking_be.entity.BookingStatus;

public class BookingStatusMapper {
    public static BookingStatusDto mapToDto(BookingStatus bookingStatus) {
        return new BookingStatusDto(
                bookingStatus.getId(),
                bookingStatus.getStatusName()
        );
    }

    public static BookingStatus mapToEntity(BookingStatusDto bookingStatusDto) {
        BookingStatus bookingStatus = new BookingStatus();
        bookingStatus.setId(bookingStatusDto.getId());
        bookingStatus.setStatusName(bookingStatusDto.getStatusName());
        return bookingStatus;
    }
}
