package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.BookingStatusDto;
import com.GWAMINC.booking_be.entity.BookingStatus;
import com.GWAMINC.booking_be.mapper.BookingStatusMapper;
import com.GWAMINC.booking_be.repository.BookingStatusRepository;
import com.GWAMINC.booking_be.service.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingStatusServiceImpl implements BookingStatusService {

    @Autowired
    private BookingStatusRepository bookingStatusRepository;

    @Override
    public BookingStatusDto createBookingStatus(BookingStatusDto bookingStatusDto) {
        BookingStatus bookingStatus = BookingStatusMapper.mapToEntity(bookingStatusDto);
        BookingStatus savedBookingStatus = bookingStatusRepository.save(bookingStatus);
        return BookingStatusMapper.mapToDto(savedBookingStatus);
    }

    @Override
    public List<BookingStatusDto> getAllBookingStatuses() {
        return bookingStatusRepository.findAll().stream()
                .map(BookingStatusMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingStatusDto getBookingStatusById(Long id) {
        BookingStatus bookingStatus = bookingStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingStatus not found"));
        return BookingStatusMapper.mapToDto(bookingStatus);
    }

    @Override
    public BookingStatusDto updateBookingStatusById(Long id, BookingStatusDto bookingStatusDto) {
        BookingStatus existingBookingStatus = bookingStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingStatus not found"));
        existingBookingStatus.setStatusName(bookingStatusDto.getStatusName());

        BookingStatus updatedBookingStatus = bookingStatusRepository.save(existingBookingStatus);
        return BookingStatusMapper.mapToDto(updatedBookingStatus);
    }

    @Override
    public void deleteBookingStatusById(Long id) {
        bookingStatusRepository.deleteById(id);
    }
}
