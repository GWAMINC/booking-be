package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;
import com.GWAMINC.booking_be.dto.AttributeDto;
import com.GWAMINC.booking_be.entity.Attribute;
import com.GWAMINC.booking_be.mapper.AttributeMapper;
import com.GWAMINC.booking_be.repository.AttributeRepository;
import com.GWAMINC.booking_be.service.impl.PropertyAttributeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AttributeServiceTest {
    @Mock
    AttributeRepository attributeRepository;

    @InjectMocks
    PropertyAttributeServiceImpl attributeService;

    private AttributeDto mockAttributeDto()
    {
        return new AttributeDto(
                1L,
                "att_test",
                "description_test",
                new AttributeCategoryDto()
        );
    }

    @Test
    void createAttributeSuccessfully() {
        AttributeDto mockAttributeDto = mockAttributeDto();
        Attribute mockAttribute = AttributeMapper.mapToEntity(mockAttributeDto);

        when(attributeRepository.save(any(Attribute.class))).thenReturn(mockAttribute);

        AttributeDto resultDto = attributeService.createAttribute(mockAttributeDto);

        verify(attributeRepository).save(any(Attribute.class));
        assertThat(resultDto.getName()).isEqualTo(mockAttributeDto.getName());
    }

    @Test
    void getAttributeByIdSuccessfully() {
        Long id = 1L;
        AttributeDto mockAttributeDto = mockAttributeDto();
        Attribute mockAttribute = AttributeMapper.mapToEntity(mockAttributeDto);

        when(attributeRepository.findById(id)).thenReturn(java.util.Optional.of(mockAttribute));
        AttributeDto resultDto = attributeService.getAttributeById(id);

        verify(attributeRepository).findById(id);
        assertThat(resultDto.getName()).isEqualTo(mockAttributeDto.getName());
    }

    @Test
    void deleteAttributeSuccessfully() {
        Long id = 1L;
        attributeService.deleteAttributeById(id);
        verify(attributeRepository).deleteById(id);
    }

    @Test
    void updateAttributeSuccessfully() {
        AttributeDto mockAttributeDto = mockAttributeDto();
        Attribute mockAttribute = AttributeMapper.mapToEntity(mockAttributeDto);

        when(attributeRepository.findById(mockAttributeDto.getId())).thenReturn(java.util.Optional.of(mockAttribute));
        when(attributeRepository.save(any(Attribute.class))).thenReturn(mockAttribute);

        AttributeDto resultDto = attributeService.updateAttributeById(mockAttributeDto.getId(), mockAttributeDto);

        verify(attributeRepository).findById(mockAttributeDto.getId());
        verify(attributeRepository).save(any(Attribute.class));

        assertThat(resultDto.getName()).isEqualTo(mockAttributeDto.getName());
    }
}
