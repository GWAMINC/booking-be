package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.CountryDto;
import com.GWAMINC.booking_be.dto.LocationDto;
import com.GWAMINC.booking_be.entity.Country;
import com.GWAMINC.booking_be.entity.Location;
import com.GWAMINC.booking_be.mapper.CountryMapper;
import com.GWAMINC.booking_be.mapper.LocationMapper;
import com.GWAMINC.booking_be.repository.LocationRepository;
import com.GWAMINC.booking_be.service.impl.LocationServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationServiceImpl locationService;

    private Location location;
    private LocationDto locationDto;
    private Country country;
    private CountryDto countryDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        country = new Country(1L, "Country Name", null);
        countryDto = CountryMapper.mapToDto(country);
        location = new Location(1L, "Location Name", country);
        locationDto = LocationMapper.mapToDto(location);
    }

    @Test
    void createLocationSuccessfully() {
        when(locationRepository.save(any(Location.class))).thenReturn(location);

        LocationDto savedLocation = locationService.createLocation(locationDto);

        assertNotNull(savedLocation);
        assertEquals(locationDto.getName(), savedLocation.getName());
        verify(locationRepository).save(any(Location.class));
    }

    @Test
    void getAllLocationsSuccessfully() {
        List<Location> locations = Arrays.asList(location);
        when(locationRepository.findAll()).thenReturn(locations);

        List<LocationDto> locationDtoList = locationService.getAllLocations();

        assertNotNull(locationDtoList);
        assertEquals(1, locationDtoList.size());
        assertEquals(location.getName(), locationDtoList.get(0).getName());
        verify(locationRepository).findAll();
    }

    @Test
    void getLocationByIdSuccessfully() {
        Long id = 1L;
        when(locationRepository.findById(id)).thenReturn(Optional.of(location));

        LocationDto foundLocation = locationService.getLocationById(id);

        assertNotNull(foundLocation);
        assertEquals(location.getName(), foundLocation.getName());
        verify(locationRepository).findById(id);
    }

    @Test
    void getLocationByIdNotFound() {
        Long id = 1L;
        when(locationRepository.findById(id)).thenReturn(Optional.empty());

        LocationDto foundLocation = locationService.getLocationById(id);

        assertNull(foundLocation);
        verify(locationRepository).findById(id);
    }

    @Test
    void deleteLocationSuccessfully() {
        Long id = 1L;
        doNothing().when(locationRepository).deleteById(id);

        locationService.deleteLocationById(id);

        verify(locationRepository).deleteById(id);
    }

    @Test
    void updateLocationSuccessfully() {
        when(locationRepository.findById(locationDto.getId())).thenReturn(Optional.of(location));
        when(locationRepository.save(any(Location.class))).thenReturn(location);

        LocationDto updatedLocation = locationService.updateLocationById(locationDto.getId(), locationDto);

        assertNotNull(updatedLocation);
        assertEquals(locationDto.getName(), updatedLocation.getName());
        verify(locationRepository).findById(locationDto.getId());
        verify(locationRepository).save(any(Location.class));
    }

    @Test
    void updateLocationNotFound() {
        when(locationRepository.findById(locationDto.getId())).thenReturn(Optional.empty());

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            locationService.updateLocationById(locationDto.getId(), locationDto);
        });

        assertEquals("Location with id [%d] not found".formatted(locationDto.getId()), exception.getMessage());
        verify(locationRepository).findById(locationDto.getId());
    }
}
