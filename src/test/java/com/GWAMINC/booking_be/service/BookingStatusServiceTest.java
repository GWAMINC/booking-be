package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.BookingStatusDto;
import com.GWAMINC.booking_be.entity.BookingStatus;
import com.GWAMINC.booking_be.mapper.BookingStatusMapper;
import com.GWAMINC.booking_be.repository.BookingStatusRepository;
import com.GWAMINC.booking_be.service.impl.BookingStatusServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookingStatusServiceTest {

    @InjectMocks
    private BookingStatusServiceImpl bookingStatusService;

    @Mock
    private BookingStatusRepository bookingStatusRepository;

    private BookingStatus bookingStatus;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookingStatus = new BookingStatus(1L, "Confirmed");
    }

    @Test
    void testCreateBookingStatus() {
        BookingStatusDto dto = BookingStatusMapper.mapToDto(bookingStatus);
        when(bookingStatusRepository.save(any(BookingStatus.class))).thenReturn(bookingStatus);

        BookingStatusDto createdDto = bookingStatusService.createBookingStatus(dto);

        assertEquals(dto.getId(), createdDto.getId());
        assertEquals(dto.getStatusName(), createdDto.getStatusName());
        verify(bookingStatusRepository, times(1)).save(any(BookingStatus.class));
    }

    @Test
    void testGetBookingStatusById() {
        when(bookingStatusRepository.findById(1L)).thenReturn(Optional.of(bookingStatus));

        BookingStatusDto foundDto = bookingStatusService.getBookingStatusById(1L);

        assertEquals(bookingStatus.getId(), foundDto.getId());
        assertEquals(bookingStatus.getStatusName(), foundDto.getStatusName());
    }

    @Test
    void testUpdateBookingStatusById() {
        BookingStatusDto dto = BookingStatusMapper.mapToDto(bookingStatus);
        when(bookingStatusRepository.findById(1L)).thenReturn(Optional.of(bookingStatus));
        when(bookingStatusRepository.save(any(BookingStatus.class))).thenReturn(bookingStatus);

        BookingStatusDto updatedDto = bookingStatusService.updateBookingStatusById(1L, dto);

        assertEquals(dto.getId(), updatedDto.getId());
        assertEquals(dto.getStatusName(), updatedDto.getStatusName());
    }

    @Test
    void testDeleteBookingStatusById() {
        doNothing().when(bookingStatusRepository).deleteById(1L);
        bookingStatusService.deleteBookingStatusById(1L);
        verify(bookingStatusRepository, times(1)).deleteById(1L);
    }
}
