package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.CategoryDto;
import com.GWAMINC.booking_be.entity.Category;

public class CategoryMapper {
    public static CategoryDto mapToDto(Category category) {
        return new CategoryDto(category.getId(), category.getCategoryName());
    }

    public static Category mapToEntity(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getCategoryName());
    }
}
