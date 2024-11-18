package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.service.CountryService;
import com.GWAMINC.booking_be.repository.CountryRepository;
import com.GWAMINC.booking_be.entity.Country;
import com.GWAMINC.booking_be.dto.CountryDto;
import com.GWAMINC.booking_be.mapper.CountryMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{
    private final CountryRepository countryRepository;

    @Override
    public CountryDto createCountry(CountryDto countryDto){
        Country country = CountryMapper.mapToEntity(countryDto);
        return CountryMapper.mapToDto(countryRepository.save(country));
    }

    @Override
    public List<CountryDto> getAllCountries(){
    return countryRepository.findAll()
                                .stream()
                                .map(country -> CountryMapper.mapToDto(country))
                                .collect(Collectors.toList());
    }

    @Override
    public CountryDto getCountryById(Long id){
        Country country = countryRepository.findById(id).orElse(null);
        if (country == null) return null;
        return CountryMapper.mapToDto(country);
    }

    @Override
    public List<CountryDto> getCountriesByRegionId(Long regionId) {
        return countryRepository.findByRegionId(regionId)
                .stream()
                .map(CountryMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCountryById(Long id){
        countryRepository.deleteById(id);
    }

    @Override
    public CountryDto updateCountryById(Long id, CountryDto countryDto) {
        Country oldCountry = countryRepository.findById(id)
                                            .orElseThrow(() -> new EntityNotFoundException("Country with id [%d] not found".formatted(id)));
        Country newCountry = CountryMapper.mapToEntity(countryDto);
        newCountry.setId(oldCountry.getId());
        countryRepository.save(newCountry);
        return CountryMapper.mapToDto(newCountry);
    }

}
