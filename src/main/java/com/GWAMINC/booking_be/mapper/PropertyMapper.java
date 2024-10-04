package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.PropertyDto;
import com.GWAMINC.booking_be.entity.Property;

public class PropertyMapper {
    public static PropertyDto mapToDto(Property property) {
        return new PropertyDto(
                property.getId(),
                property.getPropertyName(),
                LocationMapper.mapToDto(property.getLocation()),
                PlaceTypeMapper.mapToDto(property.getPlaceType()),
                PropertyTypeMapper.mapToDto(property.getPropertyType()),
                property.getNightlyPrice(),
                property.getNumGuests(),
                property.getNumBeds(),
                property.getNumBedrooms(),
                property.getNumBathrooms(),
                property.getIsGuestFavourite(),
                property.getDescription(),
                property.getAddressLine1(),
                property.getAddressLine2(),
                property.getHost()
        );
    }

    public static Property mapToEntity(PropertyDto propertyDto) {
        return new Property(
                propertyDto.getId(),
                propertyDto.getPropertyName(),
                LocationMapper.mapToEntity(propertyDto.getLocation()),
                PlaceTypeMapper.mapToEntity(propertyDto.getPlaceType()),
                PropertyTypeMapper.mapToEntity(propertyDto.getPropertyType()),
                propertyDto.getNightlyPrice(),
                propertyDto.getNumGuests(),
                propertyDto.getNumBeds(),
                propertyDto.getNumBedrooms(),
                propertyDto.getNumBathrooms(),
                propertyDto.getIsGuestFavourite(),
                propertyDto.getDescription(),
                propertyDto.getAddressLine1(),
                propertyDto.getAddressLine2(),
                propertyDto.getHost()
        );
    }
}
