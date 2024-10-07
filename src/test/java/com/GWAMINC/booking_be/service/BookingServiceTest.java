package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.BookingDto;
import com.GWAMINC.booking_be.entity.Booking;
import com.GWAMINC.booking_be.entity.Property;
import com.GWAMINC.booking_be.entity.UserAccount;
import com.GWAMINC.booking_be.entity.BookingStatus;
import com.GWAMINC.booking_be.mapper.BookingMapper;
import com.GWAMINC.booking_be.repository.BookingRepository;
import com.GWAMINC.booking_be.service.impl.BookingServiceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private Booking booking;
    private BookingDto bookingDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample Property, UserAccount, and BookingStatus for testing
        Property property = new Property();
        property.setId(1L);

        UserAccount user = new UserAccount();
        user.setId(1L);

        BookingStatus bookingStatus = new BookingStatus();
        bookingStatus.setId(1L);

        // Create a sample Booking entity
        booking = new Booking();
        booking.setId(1L);
        booking.setProperty(property);
        booking.setUser(user);
        booking.setBookingStatus(bookingStatus);
        booking.setCheckinDate(new Date());
        booking.setCheckoutDate(new Date());
        booking.setNightlyPrice(100.0);
        booking.setServiceFee(10.0);
        booking.setCleaningFee(5.0);
        booking.setTotalPrice(115.0);

        // Create a sample BookingDto
        bookingDto = BookingMapper.mapToDto(booking);
    }

    @Test
    public void createBookingSuccessfully() {
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        BookingDto resultDto = bookingService.createBooking(bookingDto);

        verify(bookingRepository).save(any(Booking.class));
        assertThat(resultDto).isEqualToComparingFieldByField(bookingDto);
    }

    @Test
    public void getAllBookingsSuccessfully() {
        when(bookingRepository.findAll()).thenReturn(Arrays.asList(booking));

        List<BookingDto> result = bookingService.getAllBookings();

        verify(bookingRepository).findAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualToComparingFieldByField(bookingDto);
    }

    @Test
    public void getBookingByIdSuccessfully() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.of(booking));

        BookingDto resultDto = bookingService.getBookingById(booking.getId());

        verify(bookingRepository).findById(booking.getId());
        assertThat(resultDto).isEqualToComparingFieldByField(bookingDto);
    }

    @Test
    public void getBookingByIdThrowsExceptionWhenNotFound() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            bookingService.getBookingById(booking.getId());
        });

        verify(bookingRepository).findById(booking.getId());
    }

    @Test
    public void updateBookingSuccessfully() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.of(booking));
        when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

        BookingDto resultDto = bookingService.updateBookingById(booking.getId(), bookingDto);

        verify(bookingRepository).findById(booking.getId());
        verify(bookingRepository).save(any(Booking.class));
        assertThat(resultDto).isEqualToComparingFieldByField(bookingDto);
    }

    @Test
    public void updateBookingThrowsExceptionWhenNotFound() {
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            bookingService.updateBookingById(booking.getId(), bookingDto);
        });

        verify(bookingRepository).findById(booking.getId());
    }

    @Test
    public void deleteBookingSuccessfully() {
        doNothing().when(bookingRepository).deleteById(booking.getId());

        bookingService.deleteBookingById(booking.getId());

        verify(bookingRepository).deleteById(booking.getId());
    }
}
