package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.BookingGuestsDto;
import com.GWAMINC.booking_be.entity.Booking;
import com.GWAMINC.booking_be.entity.BookingGuests;
import com.GWAMINC.booking_be.entity.GuestType;
import com.GWAMINC.booking_be.mapper.BookingGuestsMapper;
import com.GWAMINC.booking_be.repository.BookingGuestsRepository;
import com.GWAMINC.booking_be.service.impl.BookingGuestsServiceImpl;
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

public class BookingGuestsServiceTest {

    @Mock
    private BookingGuestsRepository bookingGuestsRepository;

    @InjectMocks
    private BookingGuestsServiceImpl bookingGuestsService;

    private BookingGuests bookingGuests;
    private BookingGuestsDto bookingGuestsDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample Booking and GuestType for testing
        Booking booking = new Booking();
        booking.setId(1L);

        GuestType guestType = new GuestType();
        guestType.setId(1L);

        // Create a sample BookingGuests entity
        bookingGuests = new BookingGuests();
        bookingGuests.setId(1L);
        bookingGuests.setBooking(booking);
        bookingGuests.setGuestType(guestType);
        bookingGuests.setNumGuests(3);

        // Create a sample BookingGuestsDto
        bookingGuestsDto = BookingGuestsMapper.mapToDto(bookingGuests);
    }

    @Test
    public void createBookingGuestSuccessfully() {
        when(bookingGuestsRepository.save(any(BookingGuests.class))).thenReturn(bookingGuests);

        BookingGuestsDto resultDto = bookingGuestsService.createBookingGuest(bookingGuestsDto);

        verify(bookingGuestsRepository).save(any(BookingGuests.class));
        assertThat(resultDto).isEqualToComparingFieldByField(bookingGuestsDto);
    }

    @Test
    public void getAllBookingGuestsSuccessfully() {
        when(bookingGuestsRepository.findAll()).thenReturn(Arrays.asList(bookingGuests));

        List<BookingGuestsDto> result = bookingGuestsService.getAllBookingGuests();

        verify(bookingGuestsRepository).findAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualToComparingFieldByField(bookingGuestsDto);
    }

    @Test
    public void getBookingGuestByIdSuccessfully() {
        when(bookingGuestsRepository.findById(bookingGuests.getId())).thenReturn(Optional.of(bookingGuests));

        BookingGuestsDto resultDto = bookingGuestsService.getBookingGuestById(bookingGuests.getId());

        verify(bookingGuestsRepository).findById(bookingGuests.getId());
        assertThat(resultDto).isEqualToComparingFieldByField(bookingGuestsDto);
    }

    @Test
    public void getBookingGuestByIdThrowsExceptionWhenNotFound() {
        when(bookingGuestsRepository.findById(bookingGuests.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            bookingGuestsService.getBookingGuestById(bookingGuests.getId());
        });

        verify(bookingGuestsRepository).findById(bookingGuests.getId());
    }

    @Test
    public void updateBookingGuestSuccessfully() {
        when(bookingGuestsRepository.findById(bookingGuests.getId())).thenReturn(Optional.of(bookingGuests));
        when(bookingGuestsRepository.save(any(BookingGuests.class))).thenReturn(bookingGuests);

        BookingGuestsDto resultDto = bookingGuestsService.updateBookingGuestById(bookingGuests.getId(), bookingGuestsDto);

        verify(bookingGuestsRepository).findById(bookingGuests.getId());
        verify(bookingGuestsRepository).save(any(BookingGuests.class));
        assertThat(resultDto).isEqualToComparingFieldByField(bookingGuestsDto);
    }

    @Test
    public void updateBookingGuestThrowsExceptionWhenNotFound() {
        when(bookingGuestsRepository.findById(bookingGuests.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            bookingGuestsService.updateBookingGuestById(bookingGuests.getId(), bookingGuestsDto);
        });

        verify(bookingGuestsRepository).findById(bookingGuests.getId());
    }

    @Test
    public void deleteBookingGuestSuccessfully() {
        bookingGuestsService.deleteBookingGuestById(bookingGuests.getId());

        verify(bookingGuestsRepository).deleteById(bookingGuests.getId());
    }
}
