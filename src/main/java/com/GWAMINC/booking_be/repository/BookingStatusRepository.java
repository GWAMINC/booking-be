package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {
}
