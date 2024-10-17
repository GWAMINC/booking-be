package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;
import com.GWAMINC.booking_be.dto.AttributeDto;
import com.GWAMINC.booking_be.dto.PropertyAttributeDto;
import com.GWAMINC.booking_be.entity.Attribute;
import com.GWAMINC.booking_be.entity.AttributeCategory;
import com.GWAMINC.booking_be.entity.Property;
import com.GWAMINC.booking_be.entity.PropertyAttribute;
import com.GWAMINC.booking_be.mapper.AttributeCategoryMapper;
import com.GWAMINC.booking_be.mapper.AttributeMapper;
import com.GWAMINC.booking_be.mapper.PropertyAttributeMapper;
import com.GWAMINC.booking_be.mapper.PropertyMapper;
import com.GWAMINC.booking_be.repository.*;
import com.GWAMINC.booking_be.service.PropertyAttributeService;
import com.GWAMINC.booking_be.repository.AttributeCategoryRepository;
import com.GWAMINC.booking_be.repository.AttributeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyAttributeServiceImpl implements PropertyAttributeService {
    private final PropertyRepository propertyRepository;
    private final PropertyAttributeRepository propertyAttributeRepository;
    private final AttributeRepository attributeRepository;
    private final AttributeCategoryRepository attributeCategoryRepository;

    @Override
    public PropertyAttributeDto createPropertyAttribute(PropertyAttributeDto propertyAttributeDto){
        PropertyAttribute propertyAttribute = PropertyAttributeMapper.mapToEntity(propertyAttributeDto);
        return PropertyAttributeMapper.mapToDto(propertyAttributeRepository.save(propertyAttribute));
    }

    @Override
    public PropertyAttributeDto getById(Long id){
        PropertyAttribute propertyAttribute = propertyAttributeRepository.findById(id).orElse(null);
        if (propertyAttribute == null) return null;
        return PropertyAttributeMapper.mapToDto(propertyAttribute);
    }

    @Override
    public PropertyAttributeDto updatePropertyAttributeById(Long id, PropertyAttributeDto propertyAttributeDto){
        PropertyAttribute oldPropertyAttribute = propertyAttributeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PropertyAttribute with id [%d] not found".formatted(id)));
        PropertyAttribute newPropertyAttribute = PropertyAttributeMapper.mapToEntity(propertyAttributeDto);
        newPropertyAttribute.setId(oldPropertyAttribute.getId());
        propertyAttributeRepository.save(newPropertyAttribute);
        return PropertyAttributeMapper.mapToDto(newPropertyAttribute);
    }

    @Override
    public void deletePropertyAttributeById(Long id){
        propertyAttributeRepository.deleteById(id);
    }
    @Override
    public AttributeDto createAttribute(AttributeDto attributeDto){
        Attribute attribute = AttributeMapper.mapToEntity(attributeDto);
        return AttributeMapper.mapToDto(attributeRepository.save(attribute));
    }

    @Override
    public AttributeDto getAttributeById(Long id){
        Attribute attribute = attributeRepository.findById(id).orElse(null);
        if (attribute == null) return null;
        return AttributeMapper.mapToDto(attribute);
    }
    @Override
    public List<AttributeDto> getAllAttributeByPropertyId(Long id){
        return propertyAttributeRepository.findAllAttributeByPropertyId(id)
                .stream()
                .map(propertyAttribute -> AttributeMapper.mapToDto(propertyAttribute.getAttribute()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AttributeDto> getAllAttributes(){
        return attributeRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Attribute::getId))
                .map(AttributeMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public AttributeDto updateAttributeById(Long id, AttributeDto attributeDto){
        Attribute oldAttribute = attributeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Attribute with id [%d] not found".formatted(id)));
        Attribute newAttribute = AttributeMapper.mapToEntity(attributeDto);
        newAttribute.setId(oldAttribute.getId());
        attributeRepository.save(newAttribute);
        return AttributeMapper.mapToDto(newAttribute);
    }

    @Override
    public void deleteAttributeById(Long id){
        attributeRepository.deleteById(id);
    }

    @Override
    public AttributeCategoryDto createAttributeCategory(AttributeCategoryDto attributeCategoryDto){
        AttributeCategory attributeCategory = AttributeCategoryMapper.mapToEntity(attributeCategoryDto);
        return AttributeCategoryMapper.mapToDto(attributeCategoryRepository.save(attributeCategory));
    }

    @Override
    public AttributeCategoryDto getAttributeCategoryById(Long id){
        AttributeCategory attributeCategory = attributeCategoryRepository.findById(id).orElse(null);
        if (attributeCategory == null) return null;
        return AttributeCategoryMapper.mapToDto(attributeCategory);
    }
    @Override
    public List<AttributeCategoryDto> getAllAttributeCategories(){
        return attributeCategoryRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(AttributeCategory::getId))
                .map(AttributeCategoryMapper::mapToDto)
                .collect(Collectors.toList());
    }
    @Override
    public AttributeCategoryDto updateAttributeCategoryById(Long id, AttributeCategoryDto attributeCategoryDto){
        AttributeCategory oldAttributeCategory = attributeCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("AttributeCategory with id [%d] not found".formatted(id)));
        AttributeCategory newAttributeCategory = AttributeCategoryMapper.mapToEntity(attributeCategoryDto);
        newAttributeCategory.setId(oldAttributeCategory.getId());
        attributeCategoryRepository.save(newAttributeCategory);
        return AttributeCategoryMapper.mapToDto(newAttributeCategory);
    }

    @Override
    public void deleteAttributeCategoryById(Long id){
        attributeCategoryRepository.deleteById(id);
    }
}
