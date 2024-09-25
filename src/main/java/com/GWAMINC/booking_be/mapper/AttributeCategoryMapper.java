package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;
import com.GWAMINC.booking_be.entity.AttributeCategory;
public class AttributeCategoryMapper {
    public static AttributeCategoryDto mapToDto(AttributeCategory attributeCategory) {
        return new AttributeCategoryDto(attributeCategory.getId(), attributeCategory.getName());
    }
    public static AttributeCategory mapToEntity(AttributeCategoryDto attributeCategoryDto) {
        return new AttributeCategory(attributeCategoryDto.getId(), attributeCategoryDto.getName());
    }
}
