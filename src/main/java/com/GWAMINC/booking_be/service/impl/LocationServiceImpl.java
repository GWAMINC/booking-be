package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.service.LocationService;
import com.GWAMINC.booking_be.repository.LocationRepository;
import com.GWAMINC.booking_be.entity.Location;
import com.GWAMINC.booking_be.dto.LocationDto;
import com.GWAMINC.booking_be.mapper.LocationMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public LocationDto createLocation(LocationDto locationDto) {
        Location location = LocationMapper.mapToEntity(locationDto);
        return LocationMapper.mapToDto(locationRepository.save(location));
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(location -> LocationMapper.mapToDto(location))
                .collect(Collectors.toList());
    }

    @Override
    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id).orElse(null);
        if (location == null) return null;
        return LocationMapper.mapToDto(location);
    }

    @Override
    public void deleteLocationById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public LocationDto updateLocationById(Long id, LocationDto locationDto) {
        Location oldLocation = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location with id [%d] not found".formatted(id)));
        Location newLocation = LocationMapper.mapToEntity(locationDto);
        newLocation.setId(oldLocation.getId());
        locationRepository.save(newLocation);
        return LocationMapper.mapToDto(newLocation);
    }
}
