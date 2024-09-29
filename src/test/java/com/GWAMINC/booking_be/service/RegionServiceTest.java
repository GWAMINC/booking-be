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

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegionServiceTest {

    @Mock
    RegionRepository regionRepository;

    @InjectMocks
    RegionServiceImpl regionService;

    private RegionDto mockRegionDto() {
        return new RegionDto(1L, "Mock Name");
    }

    @Test
    void createRegionSuccessfully() {
        RegionDto mockRegionDto = mockRegionDto();
        Region mockRegion = RegionMapper.mapToEntity(mockRegionDto);

        when(regionRepository.save(any(Region.class))).thenReturn(mockRegion);

        RegionDto resultDto = regionService.createRegion(mockRegionDto);

        assertThat(resultDto.getName()).isEqualTo(mockRegionDto.getName());

        verify(regionRepository).save(any(Region.class));
    }

    @Test
    void getAllRegionSuccessfully() {
        // Giả lập dữ liệu trả về từ repository
        when(regionRepository.findAll()).thenReturn(List.of(
                new Region(1L, "Region 1"),
                new Region(2L, "Region 2")
        ));

        // Gọi phương thức để kiểm tra
        Iterable<RegionDto> result = regionService.getAllRegions();

        // Kiểm tra kết quả
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2); // Kiểm tra số lượng region trả về

        verify(regionRepository).findAll(); // Xác nhận rằng phương thức findAll của repository đã được gọi
    }

    @Test
    void getRegionByIdSuccessfully() {
        Long id = 1L;
        RegionDto mockRegionDto = mockRegionDto();
        Region mockRegion = RegionMapper.mapToEntity(mockRegionDto);

        when(regionRepository.findById(id)).thenReturn(Optional.of(mockRegion));

        RegionDto resultDto = regionService.getRegionById(id);

        assertThat(resultDto).isNotNull();
        assertThat(resultDto.getId()).isEqualTo(id);
        assertThat(resultDto.getName()).isEqualTo(mockRegionDto.getName());

        verify(regionRepository).findById(id);
    }

    @Test
    void updateRegionSuccessfully() {
        RegionDto mockRegionDto = mockRegionDto();
        Region mockRegion = RegionMapper.mapToEntity(mockRegionDto);

        when(regionRepository.findById(mockRegionDto.getId())).thenReturn(Optional.of(mockRegion));
        when(regionRepository.save(any(Region.class))).thenReturn(mockRegion);

        RegionDto resultDto = regionService.updateRegionById(mockRegionDto.getId(), mockRegionDto);

        assertThat(resultDto).isNotNull();
        assertThat(resultDto.getId()).isEqualTo(mockRegionDto.getId());
        assertThat(resultDto.getName()).isEqualTo(mockRegionDto.getName());

        verify(regionRepository).findById(mockRegionDto.getId());
        verify(regionRepository).save(any(Region.class));
    }

    @Test
    void deleteRegionSuccessfully() {
        Long id = 1L;
        regionService.deleteRegionById(id);

        verify(regionRepository).deleteById(id);
    }
}
