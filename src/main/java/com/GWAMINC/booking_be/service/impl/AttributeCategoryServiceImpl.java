package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;
import com.GWAMINC.booking_be.entity.AttributeCategory;
import com.GWAMINC.booking_be.mapper.AttributeCategoryMapper;
import com.GWAMINC.booking_be.repository.AttributeCategoryRepository;
import com.GWAMINC.booking_be.service.AttributeCategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttributeCategoryServiceImpl implements AttributeCategoryService{
    private final AttributeCategoryRepository attributeCategoryRepository;

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
