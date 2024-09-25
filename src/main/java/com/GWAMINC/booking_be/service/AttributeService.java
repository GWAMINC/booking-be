package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.AttributeDto;
public interface AttributeService {
    AttributeDto createAttribute(AttributeDto attributeDto);
    AttributeDto getAttributeById(Long id);
    AttributeDto updateAttributeById(Long id, AttributeDto attributeDto);
    void deleteAttributeById(Long id);
}
