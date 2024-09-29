package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.RegionDto;
import com.GWAMINC.booking_be.entity.Region;
import com.GWAMINC.booking_be.mapper.RegionMapper;
import com.GWAMINC.booking_be.repository.RegionRepository;
import com.GWAMINC.booking_be.service.RegionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    @Override
    public RegionDto createRegion(RegionDto regionDto) {
        Region region = RegionMapper.mapToEntity(regionDto);
        return RegionMapper.mapToDto(regionRepository.save(region));
    }

    @Override
    public RegionDto getRegionById(Long id) {
        Region region = regionRepository.findById(id).orElse(null);
        if (region == null) return null;
        return RegionMapper.mapToDto(region);
    }

    @Override
    public List<RegionDto> getAllRegions() {
        List<Region> regions = regionRepository.findAll();
        return regions.stream().map(RegionMapper::mapToDto).toList();
    }

    @Override
    public void deleteRegionById(Long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public RegionDto updateRegionById(Long id, RegionDto regionDto) {
        Region oldRegion = regionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Region with id [%d] not found".formatted(id)));
        Region newRegion = RegionMapper.mapToEntity(regionDto);
        newRegion.setId(oldRegion.getId());
        return RegionMapper.mapToDto(regionRepository.save(newRegion));

    }
}
