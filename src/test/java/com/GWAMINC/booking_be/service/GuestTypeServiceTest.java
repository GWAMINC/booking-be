package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.GuestTypeDto;
import com.GWAMINC.booking_be.entity.GuestType;
import com.GWAMINC.booking_be.mapper.GuestTypeMapper;
import com.GWAMINC.booking_be.repository.GuestTypeRepository;
import com.GWAMINC.booking_be.service.impl.GuestTypeServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GuestTypeServiceTest {

    @Mock
    private GuestTypeRepository guestTypeRepository;

    @InjectMocks
    private GuestTypeServiceImpl guestTypeService;

    private GuestType guestType;
    private GuestTypeDto guestTypeDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample GuestType entity
        guestType = new GuestType();
        guestType.setId(1L);
        guestType.setTypeName("Adult");

        // Create a sample GuestTypeDto
        guestTypeDto = GuestTypeMapper.mapToDto(guestType);
    }

    @Test
    public void createGuestTypeSuccessfully() {
        when(guestTypeRepository.save(any(GuestType.class))).thenReturn(guestType);

        GuestTypeDto resultDto = guestTypeService.createGuestType(guestTypeDto);

        verify(guestTypeRepository).save(any(GuestType.class));
        assertThat(resultDto).isEqualToComparingFieldByField(guestTypeDto);
    }

    @Test
    public void getAllGuestTypesSuccessfully() {
        when(guestTypeRepository.findAll()).thenReturn(Arrays.asList(guestType));

        List<GuestTypeDto> result = guestTypeService.getAllGuestTypes();

        verify(guestTypeRepository).findAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualToComparingFieldByField(guestTypeDto);
    }

    @Test
    public void getGuestTypeByIdSuccessfully() {
        when(guestTypeRepository.findById(guestType.getId())).thenReturn(Optional.of(guestType));

        GuestTypeDto resultDto = guestTypeService.getGuestTypeById(guestType.getId());

        verify(guestTypeRepository).findById(guestType.getId());
        assertThat(resultDto).isEqualToComparingFieldByField(guestTypeDto);
    }

    @Test
    public void getGuestTypeByIdThrowsExceptionWhenNotFound() {
        when(guestTypeRepository.findById(guestType.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            guestTypeService.getGuestTypeById(guestType.getId());
        });

        verify(guestTypeRepository).findById(guestType.getId());
    }

    @Test
    public void updateGuestTypeSuccessfully() {
        when(guestTypeRepository.findById(guestType.getId())).thenReturn(Optional.of(guestType));
        when(guestTypeRepository.save(any(GuestType.class))).thenReturn(guestType);

        GuestTypeDto resultDto = guestTypeService.updateGuestTypeById(guestType.getId(), guestTypeDto);

        verify(guestTypeRepository).findById(guestType.getId());
        verify(guestTypeRepository).save(any(GuestType.class));
        assertThat(resultDto).isEqualToComparingFieldByField(guestTypeDto);
    }

    @Test
    public void updateGuestTypeThrowsExceptionWhenNotFound() {
        when(guestTypeRepository.findById(guestType.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            guestTypeService.updateGuestTypeById(guestType.getId(), guestTypeDto);
        });

        verify(guestTypeRepository).findById(guestType.getId());
    }

    @Test
    public void deleteGuestTypeSuccessfully() {
        guestTypeService.deleteGuestTypeById(guestType.getId());

        verify(guestTypeRepository).deleteById(guestType.getId());
    }
}
