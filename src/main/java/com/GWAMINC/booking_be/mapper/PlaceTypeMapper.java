package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.PlaceTypeDto;
import com.GWAMINC.booking_be.entity.PlaceType;

public class PlaceTypeMapper {
    public static PlaceTypeDto mapToDto(PlaceType placeType) {
        return new PlaceTypeDto(placeType.getId(), placeType.getTypeName());
    }

    public static PlaceType mapToEntity(PlaceTypeDto placeTypeDto) {
        return new PlaceType(placeTypeDto.getId(), placeTypeDto.getTypeName());
    }
}
