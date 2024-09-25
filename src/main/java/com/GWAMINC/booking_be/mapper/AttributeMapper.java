package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.AttributeDto;
import com.GWAMINC.booking_be.entity.Attribute;
public class AttributeMapper {
    public static AttributeDto mapToDto(Attribute attribute) {
        return new AttributeDto(attribute.getId(), attribute.getName(), attribute.getDescription(), AttributeCategoryMapper.mapToDto(attribute.getAttributeCategory()));
    }
    public static Attribute mapToEntity(AttributeDto attributeDto) {
        return new Attribute(attributeDto.getId(), attributeDto.getName(), attributeDto.getDescription(), AttributeCategoryMapper.mapToEntity(attributeDto.getAttributeCategory()));
    }
}
