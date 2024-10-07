package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.BookingDto;
import com.GWAMINC.booking_be.entity.Booking;
import com.GWAMINC.booking_be.mapper.BookingMapper;
import com.GWAMINC.booking_be.repository.BookingRepository;
import com.GWAMINC.booking_be.service.BookingService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = BookingMapper.mapToEntity(bookingDto);
        Booking savedBooking = bookingRepository.save(booking);
        return BookingMapper.mapToDto(savedBooking);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(BookingMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking with id " + id + " not found"));
        return BookingMapper.mapToDto(booking);
    }

    @Override
    public BookingDto updateBookingById(Long id, BookingDto bookingDto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking with id " + id + " not found"));

        // Update booking fields
        booking.setCheckinDate(bookingDto.getCheckinDate());
        booking.setCheckoutDate(bookingDto.getCheckoutDate());
        booking.setNightlyPrice(bookingDto.getNightlyPrice());
        booking.setServiceFee(bookingDto.getServiceFee());
        booking.setCleaningFee(bookingDto.getCleaningFee());
        booking.setTotalPrice(bookingDto.getTotalPrice());

        Booking updatedBooking = bookingRepository.save(booking);
        return BookingMapper.mapToDto(updatedBooking);
    }

    @Override
    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }
}
