package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;
import com.GWAMINC.booking_be.dto.AttributeDto;
import com.GWAMINC.booking_be.dto.PropertyAttributeDto;

import java.util.List;

public interface PropertyAttributeService {
    PropertyAttributeDto createPropertyAttribute(PropertyAttributeDto propertyAttributeDto);
    List<AttributeDto> getAllAttributeByPropertyId(Long id);
    PropertyAttributeDto getById(Long id);
    void deletePropertyAttributeById(Long id);
    PropertyAttributeDto updatePropertyAttributeById(Long id, PropertyAttributeDto propertyAttributeDto);
    AttributeDto createAttribute(AttributeDto attributeDto);
    AttributeDto getAttributeById(Long id);
    List<AttributeDto> getAllAttributes();
    AttributeDto updateAttributeById(Long id, AttributeDto attributeDto);
    void deleteAttributeById(Long id);
    AttributeCategoryDto createAttributeCategory(AttributeCategoryDto attributeCategoryDto);
    AttributeCategoryDto getAttributeCategoryById(Long id);
    List<AttributeCategoryDto> getAllAttributeCategories();
    AttributeCategoryDto updateAttributeCategoryById(Long id, AttributeCategoryDto attributeCategoryDto);
    void deleteAttributeCategoryById(Long id);
}
