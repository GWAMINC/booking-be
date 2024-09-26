package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;

public interface AttributeCategoryService {
    AttributeCategoryDto createAttributeCategory(AttributeCategoryDto attributeCategoryDto);
    AttributeCategoryDto getAttributeCategoryById(Long id);
    AttributeCategoryDto updateAttributeCategoryById(Long id, AttributeCategoryDto attributeCategoryDto);
    void deleteAttributeCategoryById(Long id);
}
