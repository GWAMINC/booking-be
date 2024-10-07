package com.GWAMINC.booking_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GWAMINC.booking_be.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
