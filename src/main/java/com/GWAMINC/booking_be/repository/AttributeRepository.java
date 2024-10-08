package com.GWAMINC.booking_be.repository;

import com.GWAMINC.booking_be.entity.Attribute;
import com.GWAMINC.booking_be.entity.PropertyAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
