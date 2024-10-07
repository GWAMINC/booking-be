package com.GWAMINC.booking_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingGuestsDto {
    private Long id;
    private Long bookingId;
    private Long guestTypeId;
    private Integer numGuests;
}
