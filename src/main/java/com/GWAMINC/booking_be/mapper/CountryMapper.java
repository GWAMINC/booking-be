package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.CountryDto;
import com.GWAMINC.booking_be.entity.Country;

public class CountryMapper {
    public static CountryDto mapToDto(Country country) {
        if (country == null) {
            return null;
        }
        return new CountryDto(country.getId(), country.getName(), RegionMapper.mapToDto(country.getRegion()));
    }

    public static Country mapToEntity(CountryDto countryDto) {
        if (countryDto == null) {
            return null;
        }
        return new Country(countryDto.getId(), countryDto.getName(), RegionMapper.mapToEntity(countryDto.getRegion()));
    }
}
