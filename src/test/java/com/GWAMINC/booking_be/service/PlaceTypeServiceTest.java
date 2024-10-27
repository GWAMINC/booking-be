package com.GWAMINC.booking_be.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.GWAMINC.booking_be.dto.PlaceTypeDto;
import com.GWAMINC.booking_be.entity.PlaceType;
import com.GWAMINC.booking_be.mapper.PlaceTypeMapper;
import com.GWAMINC.booking_be.repository.PlaceTypeRepository;
import com.GWAMINC.booking_be.service.impl.PlaceTypeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PlaceTypeServiceTest {
    @Mock
    private PlaceTypeRepository placeTypeRepository;

    @InjectMocks
    private PlaceTypeServiceImpl placeTypeService;

    private PlaceType placeType;
    private PlaceTypeDto placeTypeDto;

    @BeforeEach
    public void init() {
        placeType = new PlaceType(1L, "name");
        placeTypeDto = PlaceTypeMapper.mapToDto(placeType);
    }

    @Test
    public void createPlaceTypeSuccessfully() {
        when(placeTypeRepository.save(any(PlaceType.class))).thenReturn(placeType);

        PlaceTypeDto savedPlaceType = placeTypeService.createPlaceType(placeTypeDto);

        assertThat(savedPlaceType).isNotNull();
    }

    @Test
    public void getPlaceTypeByIdSuccessfully() {
        when(placeTypeRepository.findById(placeType.getId())).thenReturn(Optional.of(placeType));

        PlaceTypeDto placeTypeDto1 = placeTypeService.getPlaceTypeById(placeType.getId());

        assertThat(placeTypeDto1).isNotNull();
    }

    @Test
    public void deletePlaceTypeByIdSuccessfully() {
        when(placeTypeRepository.findById(placeType.getId())).thenReturn(Optional.of(placeType));

        assertAll(() -> placeTypeService.deletePlaceTypeById(placeType.getId()));
    }

    @Test
    public void updatePlaceTypeByIdSuccessfully() {
        when(placeTypeRepository.findById(placeType.getId())).thenReturn(Optional.of(placeType));
        when(placeTypeRepository.save(any(PlaceType.class))).thenReturn(placeType);

        PlaceTypeDto updateReturn = placeTypeService.updatePlaceTypeById(placeType.getId(), placeTypeDto);

        assertThat(updateReturn).isNotNull();
    }
}
