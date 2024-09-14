package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.RegionDto;
import com.GWAMINC.booking_be.entity.Region;
import com.GWAMINC.booking_be.mapper.RegionMapper;
import com.GWAMINC.booking_be.repository.RegionRepository;
import com.GWAMINC.booking_be.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

//    public RegionServiceImpl(RegionRepository regionRepository) {
//        this.regionRepository = regionRepository;
//    }

    @Override
    public RegionDto createRegion(RegionDto regionDto) {
        Region region = RegionMapper.mapToEntity(regionDto);
        return RegionMapper.mapToDto(regionRepository.save(region));
    }
}
