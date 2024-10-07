package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.GuestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestTypeRepository extends JpaRepository<GuestType, Long> {
}
