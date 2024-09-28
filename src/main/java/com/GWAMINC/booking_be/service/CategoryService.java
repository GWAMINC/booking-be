package com.GWAMINC.booking_be.service;

import java.util.List;

import com.GWAMINC.booking_be.dto.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategorys();
    CategoryDto getCategoryById(Long id);
    void deleteCategoryById(Long id);
    void updateCategoryById(Long id, CategoryDto categoryDto);
}
