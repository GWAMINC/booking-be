package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.GuestTypeDto;
import com.GWAMINC.booking_be.entity.GuestType;
import com.GWAMINC.booking_be.mapper.GuestTypeMapper;
import com.GWAMINC.booking_be.repository.GuestTypeRepository;
import com.GWAMINC.booking_be.service.GuestTypeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuestTypeServiceImpl implements GuestTypeService {

    private final GuestTypeRepository guestTypeRepository;

    public GuestTypeServiceImpl(GuestTypeRepository guestTypeRepository) {
        this.guestTypeRepository = guestTypeRepository;
    }

    @Override
    public GuestTypeDto createGuestType(GuestTypeDto guestTypeDto) {
        GuestType guestType = GuestTypeMapper.mapToEntity(guestTypeDto);
        GuestType savedGuestType = guestTypeRepository.save(guestType);
        return GuestTypeMapper.mapToDto(savedGuestType);
    }

    @Override
    public List<GuestTypeDto> getAllGuestTypes() {
        return guestTypeRepository.findAll().stream()
                .map(GuestTypeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GuestTypeDto getGuestTypeById(Long id) {
        GuestType guestType = guestTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("GuestType not found with id: " + id));
        return GuestTypeMapper.mapToDto(guestType);
    }

    @Override
    public GuestTypeDto updateGuestTypeById(Long id, GuestTypeDto guestTypeDto) {
        GuestType guestType = guestTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("GuestType not found with id: " + id));

        guestType.setTypeName(guestTypeDto.getTypeName());

        GuestType updatedGuestType = guestTypeRepository.save(guestType);
        return GuestTypeMapper.mapToDto(updatedGuestType);
    }

    @Override
    public void deleteGuestTypeById(Long id) {
        guestTypeRepository.deleteById(id);
    }
}
