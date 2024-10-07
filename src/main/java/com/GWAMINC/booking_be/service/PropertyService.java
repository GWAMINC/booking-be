package com.GWAMINC.booking_be.service;

import java.util.List;
import com.GWAMINC.booking_be.dto.PropertyDto;
import com.GWAMINC.booking_be.dto.PropertyTypeDto;

public interface PropertyService {
    PropertyDto createProperty(PropertyDto propertyDto);
    PropertyDto getPropertyById(Long id);
    List<PropertyDto> getAllProperties();
    PropertyDto updateProperty(Long id, PropertyDto propertyDto);
    void deletePropertyById(Long id);

    PropertyTypeDto createPropertyType(PropertyTypeDto propertyTypeDto);
    PropertyTypeDto getPropertyTypeById(Long id);
    List<PropertyTypeDto> getAllPropertyTypes();
    PropertyTypeDto updatePropertyType(Long id, PropertyTypeDto propertyTypeDto);
    void deletePropertyTypeById(Long id);

}


