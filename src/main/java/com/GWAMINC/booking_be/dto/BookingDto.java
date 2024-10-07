package com.GWAMINC.booking_be.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private Long propertyId;
    private Long userId;
    private Long bookingStatusId;
    private Date checkinDate;
    private Date checkoutDate;
    private Double nightlyPrice;
    private Double serviceFee;
    private Double cleaningFee;
    private Double totalPrice;
}
