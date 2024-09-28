package com.GWAMINC.booking_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GWAMINC.booking_be.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
