package com.GWAMINC.booking_be.service.impl;

import com.GWAMINC.booking_be.dto.BookingGuestsDto;
import com.GWAMINC.booking_be.entity.BookingGuests;
import com.GWAMINC.booking_be.mapper.BookingGuestsMapper;
import com.GWAMINC.booking_be.repository.BookingGuestsRepository;
import com.GWAMINC.booking_be.service.BookingGuestsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingGuestsServiceImpl implements BookingGuestsService {

    private final BookingGuestsRepository bookingGuestsRepository;

    public BookingGuestsServiceImpl(BookingGuestsRepository bookingGuestsRepository) {
        this.bookingGuestsRepository = bookingGuestsRepository;
    }

    @Override
    public BookingGuestsDto createBookingGuest(BookingGuestsDto bookingGuestsDto) {
        BookingGuests bookingGuests = BookingGuestsMapper.mapToEntity(bookingGuestsDto);
        BookingGuests savedBookingGuests = bookingGuestsRepository.save(bookingGuests);
        return BookingGuestsMapper.mapToDto(savedBookingGuests);
    }

    @Override
    public List<BookingGuestsDto> getAllBookingGuests() {
        return bookingGuestsRepository.findAll().stream()
                .map(BookingGuestsMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingGuestsDto getBookingGuestById(Long id) {
        BookingGuests bookingGuests = bookingGuestsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BookingGuests not found with id: " + id));
        return BookingGuestsMapper.mapToDto(bookingGuests);
    }

    @Override
    public BookingGuestsDto updateBookingGuestById(Long id, BookingGuestsDto bookingGuestsDto) {
        BookingGuests bookingGuests = bookingGuestsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BookingGuests not found with id: " + id));

        bookingGuests.setNumGuests(bookingGuestsDto.getNumGuests());
        // You can set other fields like booking and guestType if needed here

        BookingGuests updatedBookingGuests = bookingGuestsRepository.save(bookingGuests);
        return BookingGuestsMapper.mapToDto(updatedBookingGuests);
    }

    @Override
    public void deleteBookingGuestById(Long id) {
        bookingGuestsRepository.deleteById(id);
    }
}
