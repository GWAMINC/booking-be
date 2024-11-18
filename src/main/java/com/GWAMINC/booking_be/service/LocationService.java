package com.GWAMINC.booking_be.service;

import java.util.List;
import com.GWAMINC.booking_be.dto.LocationDto;

public interface LocationService {
    LocationDto createLocation(LocationDto locationDto);
    LocationDto getLocationById(Long id);
    List<LocationDto> getAllLocations();
    List<LocationDto> getLocationsByCountryId(Long countryId);
    LocationDto updateLocationById(Long id, LocationDto locationDto);
    void deleteLocationById(Long id);
}
