package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByCountryId(Long regionId);
}
