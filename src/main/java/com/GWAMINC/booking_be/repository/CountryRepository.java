package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long>{
    List<Country> findByRegionId(Long regionId);
}
