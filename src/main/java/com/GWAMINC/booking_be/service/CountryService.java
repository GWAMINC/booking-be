package com.GWAMINC.booking_be.service;

import java.util.List;
import com.GWAMINC.booking_be.dto.CountryDto;
public interface CountryService {
    CountryDto createCountry(CountryDto countryDto);
    CountryDto getCountryById(Long id);
    List<CountryDto> getAllCountries();
    List<CountryDto> getCountriesByRegionId(Long regionId);
    CountryDto updateCountryById(Long id, CountryDto countryDto);
    void deleteCountryById(Long id);
}

