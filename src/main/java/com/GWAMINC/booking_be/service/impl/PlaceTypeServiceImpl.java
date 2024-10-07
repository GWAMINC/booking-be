package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.PlaceTypeDto;
import com.GWAMINC.booking_be.entity.PlaceType;
import com.GWAMINC.booking_be.mapper.PlaceTypeMapper;
import com.GWAMINC.booking_be.repository.PlaceTypeRepository;
import com.GWAMINC.booking_be.service.PlaceTypeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlaceTypeServiceImpl implements PlaceTypeService {
    private final PlaceTypeRepository placeTypeRepository;

    @Override
    public PlaceTypeDto createPlaceType(PlaceTypeDto placeTypeDto) {
        PlaceType placeType = PlaceTypeMapper.mapToEntity(placeTypeDto);
        return PlaceTypeMapper.mapToDto(placeTypeRepository.save(placeType));
    };

    @Override
    public List<PlaceTypeDto> getAllPlaceTypes() {
        return placeTypeRepository.findAll()
                .stream()
                .map(placeType -> PlaceTypeMapper.mapToDto(placeType))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceTypeDto getPlaceTypeById(Long id) {
        PlaceType placeType = placeTypeRepository.findById(id).orElse(null);
        if (placeType == null)
            return null;
        return PlaceTypeMapper.mapToDto(placeType);
    }

    @Override
    public void deletePlaceTypeById(Long id) {
        placeTypeRepository.deleteById(id);
    };

    @Override
    public void updatePlaceTypeById(Long id, PlaceTypeDto placeTypeDto) {
        PlaceType oldPlaceType = placeTypeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PlaceType with id [%d] not found".formatted(id)));

        PlaceType newPlaceType = PlaceTypeMapper.mapToEntity(placeTypeDto);
        newPlaceType.setId(oldPlaceType.getId());

        placeTypeRepository.save(newPlaceType);
    }
}
