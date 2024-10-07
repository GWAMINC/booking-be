package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.RegionDto;
import com.GWAMINC.booking_be.entity.Region;

public class RegionMapper {
    public static RegionDto mapToDto(Region region) {

        return new RegionDto(region.getId(), region.getName());
    }

    public static Region mapToEntity(RegionDto regionDto) {

        return new Region(regionDto.getId(), regionDto.getName());
    }
}
