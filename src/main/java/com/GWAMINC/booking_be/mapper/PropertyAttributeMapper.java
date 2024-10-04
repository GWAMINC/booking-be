package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.PropertyAttributeDto;
import com.GWAMINC.booking_be.entity.PropertyAttribute;

public class PropertyAttributeMapper {
    public static PropertyAttributeDto mapToDto(PropertyAttribute propertyAttribute) {
        return new PropertyAttributeDto(propertyAttribute.getId(), PropertyMapper.mapToDto(propertyAttribute.getProperty()), AttributeMapper.mapToDto(propertyAttribute.getAttribute()));
    }
    public static PropertyAttribute mapToEntity(PropertyAttributeDto propertyAttributeDto) {
        return new PropertyAttribute(propertyAttributeDto.getId(), PropertyMapper.mapToEntity(propertyAttributeDto.getProperty()), AttributeMapper.mapToEntity(propertyAttributeDto.getAttribute()));
    }
}
