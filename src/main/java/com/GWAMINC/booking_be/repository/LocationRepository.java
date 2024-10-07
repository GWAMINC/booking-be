package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
