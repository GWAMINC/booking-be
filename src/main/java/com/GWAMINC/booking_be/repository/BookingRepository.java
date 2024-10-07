package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
