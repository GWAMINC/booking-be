package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long>{
}
