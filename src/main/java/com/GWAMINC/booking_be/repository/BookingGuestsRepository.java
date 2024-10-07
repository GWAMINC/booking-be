package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.BookingGuests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingGuestsRepository extends JpaRepository<BookingGuests, Long> {
}
