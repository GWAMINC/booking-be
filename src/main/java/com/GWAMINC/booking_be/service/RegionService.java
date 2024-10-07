package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.RegionDto;

import java.util.List;

public interface RegionService {
    RegionDto createRegion(RegionDto regionDto);
    RegionDto getRegionById(Long id);
    List<RegionDto> getAllRegions();
    RegionDto updateRegionById(Long id,RegionDto regionDto);
    void deleteRegionById(Long id);
}
