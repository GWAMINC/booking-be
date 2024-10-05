package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.PropertyTypeDto;
import com.GWAMINC.booking_be.entity.PropertyType;

public class PropertyTypeMapper {
    public static PropertyTypeDto mapToDto(PropertyType propertyType) {
        return new PropertyTypeDto(propertyType.getId(), propertyType.getTypeName());
    }
    public static PropertyType mapToEntity(PropertyTypeDto propertyTypeDto) {
        return new PropertyType(propertyTypeDto.getId(), propertyTypeDto.getTypeName());
    }
}
