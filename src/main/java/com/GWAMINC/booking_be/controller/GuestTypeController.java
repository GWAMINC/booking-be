package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.GuestTypeDto;
import com.GWAMINC.booking_be.service.GuestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest-types")
public class GuestTypeController {

    @Autowired
    private GuestTypeService guestTypeService;

    @PostMapping
    public ResponseEntity<GuestTypeDto> createGuestType(@RequestBody GuestTypeDto guestTypeDto) {
        GuestTypeDto createdGuestType = guestTypeService.createGuestType(guestTypeDto);
        return ResponseEntity.ok(createdGuestType);
    }

    @GetMapping
    public ResponseEntity<List<GuestTypeDto>> getAllGuestTypes() {
        List<GuestTypeDto> guestTypes = guestTypeService.getAllGuestTypes();
        return ResponseEntity.ok(guestTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestTypeDto> getGuestTypeById(@PathVariable Long id) {
        GuestTypeDto guestType = guestTypeService.getGuestTypeById(id);
        return ResponseEntity.ok(guestType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestTypeDto> updateGuestTypeById(@PathVariable Long id, @RequestBody GuestTypeDto guestTypeDto) {
        GuestTypeDto updatedGuestType = guestTypeService.updateGuestTypeById(id, guestTypeDto);
        return ResponseEntity.ok(updatedGuestType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuestTypeById(@PathVariable Long id) {
        guestTypeService.deleteGuestTypeById(id);
        return ResponseEntity.noContent().build();
    }
}
