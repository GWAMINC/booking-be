package com.GWAMINC.booking_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount user;

    @ManyToOne
    @JoinColumn(name = "booking_status_id")
    private BookingStatus bookingStatus;

    @Column(name = "checkin_date")
    @Temporal(TemporalType.DATE)
    private Date checkinDate;

    @Column(name = "checkout_date")
    @Temporal(TemporalType.DATE)
    private Date checkoutDate;

    @Column(name = "nightly_price")
    private Double nightlyPrice;

    @Column(name = "service_fee")
    private Double serviceFee;

    @Column(name = "cleaning_fee")
    private Double cleaningFee;

    @Column(name = "total_price")
    private Double totalPrice;
}
