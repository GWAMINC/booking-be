package com.GWAMINC.booking_be.service;

import java.util.List;

import com.GWAMINC.booking_be.dto.PlaceTypeDto;

public interface PlaceTypeService {
    PlaceTypeDto createPlaceType(PlaceTypeDto placeTypeDto);

    List<PlaceTypeDto> getAllPlaceTypes();

    PlaceTypeDto getPlaceTypeById(Long id);

    void deletePlaceTypeById(Long id);

    void updatePlaceTypeById(Long id, PlaceTypeDto placeTypeDto);
}
