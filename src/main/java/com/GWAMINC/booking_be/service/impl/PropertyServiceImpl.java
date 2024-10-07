package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.service.PropertyService;
import com.GWAMINC.booking_be.repository.PropertyRepository;
import com.GWAMINC.booking_be.entity.Property;
import com.GWAMINC.booking_be.dto.PropertyDto;
import com.GWAMINC.booking_be.mapper.PropertyMapper;

import com.GWAMINC.booking_be.repository.PropertyTypeRepository;
import com.GWAMINC.booking_be.entity.PropertyType;
import com.GWAMINC.booking_be.dto.PropertyTypeDto;
import com.GWAMINC.booking_be.mapper.PropertyTypeMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;

    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        Property property = PropertyMapper.mapToEntity(propertyDto);
        return PropertyMapper.mapToDto(propertyRepository.save(property));
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(property -> PropertyMapper.mapToDto(property))
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDto getPropertyById(Long id) {
        Property property = propertyRepository.findById(id).orElse(null);
        if (property == null) {
            return null;
        }
        return PropertyMapper.mapToDto(property);
    }

    @Override
    public void deletePropertyById(Long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public PropertyDto updateProperty(Long id, PropertyDto propertyDto) {
        Property oldProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property with id [%d] not found".formatted(id)));
        Property newProperty = PropertyMapper.mapToEntity(propertyDto);
        newProperty.setId(oldProperty.getId());
        propertyRepository.save(newProperty);
        return PropertyMapper.mapToDto(newProperty);
    }

    private final PropertyTypeRepository propertyTypeRepository;

    @Override
    public PropertyTypeDto createPropertyType(PropertyTypeDto propertyTypeDto) {
        PropertyType propertyType = PropertyTypeMapper.mapToEntity(propertyTypeDto);
        return PropertyTypeMapper.mapToDto(propertyTypeRepository.save(propertyType));
    }

    @Override
    public List<PropertyTypeDto> getAllPropertyTypes() {
        return propertyTypeRepository.findAll()
                .stream()
                .map(propertyType -> PropertyTypeMapper.mapToDto(propertyType))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePropertyTypeById(Long id) {
        propertyTypeRepository.deleteById(id);
    }

    @Override
    public PropertyTypeDto getPropertyTypeById(Long id) {
        PropertyType propertyType = propertyTypeRepository.findById(id)
                .orElse(null);
        if (propertyType == null) {
            return null;
        }
        return PropertyTypeMapper.mapToDto(propertyType);
    }

    @Override
    public PropertyTypeDto updatePropertyType(Long id, PropertyTypeDto propertyTypeDto) {
        PropertyType oldPropertyType = propertyTypeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("PropertyType with id [%d] not found".formatted(id)));
        PropertyType newPropertyType = PropertyTypeMapper.mapToEntity(propertyTypeDto);
        newPropertyType.setId(oldPropertyType.getId());
        propertyTypeRepository.save(newPropertyType);
        return PropertyTypeMapper.mapToDto(newPropertyType);
    }
}
