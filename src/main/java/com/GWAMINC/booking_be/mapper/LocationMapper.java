package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.LocationDto;
import com.GWAMINC.booking_be.entity.Location;

public class LocationMapper {
    public static LocationDto mapToDto(Location location) {
        return new LocationDto(location.getId(), location.getName(), CountryMapper.mapToDto(location.getCountry()));
    }

    public static Location mapToEntity(LocationDto locationDto) {
        return new Location(locationDto.getId(), locationDto.getName(), CountryMapper.mapToEntity(locationDto.getCountry()));
    }
}
