package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.BookingDto;
import com.GWAMINC.booking_be.entity.Booking;

public class BookingMapper {
    public static BookingDto mapToDto(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getProperty().getId(),
                booking.getUser().getId(),
                booking.getBookingStatus().getId(),
                booking.getCheckinDate(),
                booking.getCheckoutDate(),
                booking.getNightlyPrice(),
                booking.getServiceFee(),
                booking.getCleaningFee(),
                booking.getTotalPrice()
        );
    }

    public static Booking mapToEntity(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        // Set property, user, and booking status entities based on IDs
        // Assuming Property, UserAccount, and BookingStatus services or repositories are available
        // e.g., booking.setProperty(propertyService.findById(bookingDto.getPropertyId()));
        // You need to implement these parts according to your application logic
        booking.setCheckinDate(bookingDto.getCheckinDate());
        booking.setCheckoutDate(bookingDto.getCheckoutDate());
        booking.setNightlyPrice(bookingDto.getNightlyPrice());
        booking.setServiceFee(bookingDto.getServiceFee());
        booking.setCleaningFee(bookingDto.getCleaningFee());
        booking.setTotalPrice(bookingDto.getTotalPrice());
        return booking;
    }
}
