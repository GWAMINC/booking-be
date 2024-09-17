package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.RegionDto;
import com.GWAMINC.booking_be.entity.Region;
import com.GWAMINC.booking_be.mapper.RegionMapper;
import com.GWAMINC.booking_be.repository.RegionRepository;
import com.GWAMINC.booking_be.service.impl.RegionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegionServiceTest {
    @Mock
    RegionRepository regionRepository;

    @InjectMocks
    RegionServiceImpl regionService;

    @Test
    void createRegionSuccessfully() {
        RegionDto mockRegionDto = new RegionDto();

        Region mockRegion = RegionMapper.mapToEntity(mockRegionDto);

        when(regionRepository.save(any(Region.class))).thenReturn(mockRegion);

        Region result = regionRepository.save(mockRegion);

        RegionDto resultDto = RegionMapper.mapToDto(result);

        assertThat(resultDto.getName()).isEqualTo(mockRegionDto.getName());

        verify(regionRepository).save(any(Region.class));
    }
}
