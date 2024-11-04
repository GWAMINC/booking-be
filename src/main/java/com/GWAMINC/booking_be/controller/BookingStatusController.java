package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.BookingStatusDto;
import com.GWAMINC.booking_be.service.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking-statuses")
public class BookingStatusController {

    @Autowired
    private BookingStatusService bookingStatusService;

    @PostMapping
    public ResponseEntity<BookingStatusDto> createBookingStatus(@RequestBody BookingStatusDto bookingStatusDto) {
        BookingStatusDto createdBookingStatus = bookingStatusService.createBookingStatus(bookingStatusDto);
        return ResponseEntity.ok(createdBookingStatus);
    }

    @GetMapping
    public ResponseEntity<List<BookingStatusDto>> getAllBookingStatuses() {
        List<BookingStatusDto> bookingStatuses = bookingStatusService.getAllBookingStatuses();
        return ResponseEntity.ok(bookingStatuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingStatusDto> getBookingStatusById(@PathVariable Long id) {
        BookingStatusDto bookingStatus = bookingStatusService.getBookingStatusById(id);
        return ResponseEntity.ok(bookingStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingStatusDto> updateBookingStatusById(@PathVariable Long id, @RequestBody BookingStatusDto bookingStatusDto) {
        BookingStatusDto updatedBookingStatus = bookingStatusService.updateBookingStatusById(id, bookingStatusDto);
        return ResponseEntity.ok(updatedBookingStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingStatusById(@PathVariable Long id) {
        bookingStatusService.deleteBookingStatusById(id);
        return ResponseEntity.noContent().build();
    }
}
