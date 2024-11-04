package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.BookingGuestsDto;
import com.GWAMINC.booking_be.service.BookingGuestsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-guests")
public class BookingGuestsController {

    private final BookingGuestsService bookingGuestsService;

    public BookingGuestsController(BookingGuestsService bookingGuestsService) {
        this.bookingGuestsService = bookingGuestsService;
    }

    @PostMapping
    public ResponseEntity<BookingGuestsDto> createBookingGuest(@RequestBody BookingGuestsDto bookingGuestsDto) {
        BookingGuestsDto createdBookingGuest = bookingGuestsService.createBookingGuest(bookingGuestsDto);
        return new ResponseEntity<>(createdBookingGuest, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookingGuestsDto>> getAllBookingGuests() {
        List<BookingGuestsDto> bookingGuests = bookingGuestsService.getAllBookingGuests();
        return new ResponseEntity<>(bookingGuests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingGuestsDto> getBookingGuestById(@PathVariable Long id) {
        BookingGuestsDto bookingGuestsDto = bookingGuestsService.getBookingGuestById(id);
        return new ResponseEntity<>(bookingGuestsDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingGuestsDto> updateBookingGuestById(@PathVariable Long id, @RequestBody BookingGuestsDto bookingGuestsDto) {
        BookingGuestsDto updatedBookingGuest = bookingGuestsService.updateBookingGuestById(id, bookingGuestsDto);
        return new ResponseEntity<>(updatedBookingGuest, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingGuestById(@PathVariable Long id) {
        bookingGuestsService.deleteBookingGuestById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
