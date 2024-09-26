package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.AttributeDto;
import com.GWAMINC.booking_be.entity.Attribute;
import com.GWAMINC.booking_be.mapper.AttributeMapper;
import com.GWAMINC.booking_be.repository.AttributeRepository;
import com.GWAMINC.booking_be.service.AttributeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;

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
}
